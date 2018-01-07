package com.whatsmode.custservice.shopify.order.template;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.whatsmode.custservice.shopify.order.response.OrderList;
import com.whatsmode.custservice.shopify.util.Http;

public class OrderTemplate {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Http http;

    public OrderTemplate(Http http) {
        this.http = http;
    }

    /**
     * Get orders by order name - e.g. #41156789
     *
     * @param name
     * @return
     */
    public OrderList getOrdersByName(String name) {

        if (StringUtils.isEmpty(name)) {
            logger.error("invalid parameter - name is null");
            throw new IllegalArgumentException("invalid parameter - name is null");
        }

        return findOrders("/admin/orders.json", buildQueryParams(name, null));
    }

    /**
     * Get orders by customer id - e.g. 184958713883
     *
     * @param customerId
     * @return
     */
    public OrderList getOrdersByCustomerId(String customerId) {

        if (StringUtils.isEmpty(customerId)) {
            logger.error("invalid parameter - customerId is null");
            throw new IllegalArgumentException("invalid parameter - customerId is null");
        }

        return findOrders("/admin/customers/" + customerId + "/orders.json", buildQueryParams(null, customerId));
    }

    /**
     * Retrieve a list of products. Return null if empty results or the number of results exceeded limit - 250.
     *
     * @param queryParams
     * @return
     */
    private OrderList findOrders(String path, Map<String, String> queryParams) {
        return http.getForObject(path, OrderList.class, queryParams);
    }

    private Map<String, String> buildQueryParams(String name, String customerId) {
        Map<String, String> params = new HashMap<>();
        if (!StringUtils.isEmpty(name)) {
            params.put("name", name);
        }
        if (!StringUtils.isEmpty(customerId)) {
            params.put("customer_id", customerId);
        }
        params.put("limit", "20");
        params.put("status", "any");

        return params;
    }

}
