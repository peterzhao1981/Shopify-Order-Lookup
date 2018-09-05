package com.whatsmode.custservice.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.whatsmode.custservice.shopify.Shopify;
import com.whatsmode.custservice.shopify.customer.response.CustomerList;
import com.whatsmode.custservice.shopify.event.response.Event;
import com.whatsmode.custservice.shopify.order.response.Order;

@Controller
public class HomeController {

    private static Shopify shopify = Shopify.getInstance();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/error")
    public String error() {
        return "error/error";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "error/access-denied";
    }

    @GetMapping("/secured/orders")
    public String orderIndex() {
        return "order/index";
    }

    @PostMapping("/secured/orders")
    public String findOrders(@RequestParam String input, Model model) {
        System.out.println("input: " + input);

        List<Order> orders = new ArrayList<>();
        if (!StringUtils.isEmpty(input) && input.startsWith("#411")) {
            orders = shopify.orderTemplate().getOrdersByName(input).getOrders();
        } else if (!StringUtils.isEmpty(input) && input.contains("@")) {
            CustomerList customerList = shopify.customerTemplate().getCustomerByEmail(input);
            if (!ObjectUtils.isEmpty(customerList) && !customerList.getCustomers().isEmpty()) {
                Long customerId = customerList.getCustomers().get(0).getId();
                orders = shopify.orderTemplate().getOrdersByCustomerId(String.valueOf(customerId)).getOrders();
            }
        }

        for(Order order : orders) {
            order.setFulfillmentMap();
            List<Event> events = new ArrayList<>();
            events = shopify.eventTemplate().getLatestEventByOrderId(order.getId()).getEvents();
            if (events != null && events.size() > 0) {
                Event latestEvent = events.get(0);
                order.setLatestEventMessage(latestEvent.getCreatedAt().substring(0, 10) + ": " + latestEvent
                        .getMessage());
            }
        }

        model.addAttribute("orders", orders);
        return "order/index";
    }
}
