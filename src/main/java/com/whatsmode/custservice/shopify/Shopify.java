package com.whatsmode.custservice.shopify;

import org.springframework.util.ObjectUtils;

import com.whatsmode.custservice.shopify.common.Constants;
import com.whatsmode.custservice.shopify.config.Configuration;
import com.whatsmode.custservice.shopify.customer.response.CustomerList;
import com.whatsmode.custservice.shopify.customer.template.CustomerTemplate;
import com.whatsmode.custservice.shopify.order.response.OrderList;
import com.whatsmode.custservice.shopify.order.template.OrderTemplate;
import com.whatsmode.custservice.shopify.util.Http;

/**
 * This is the primary interface to the Shopify Admin API. It is used to
 * interact with:
 * <ul>
 * <li> {@link  }
 * <li> { ProductApi Products}
 * </ul>
 * <p>
 * Shopify API call limit:
 * <ul>
 * <li> The bucket size is 40 calls (which cannot be exceeded at any given time), with a "leak rate" of 2 calls per
 * second that continually empties the bucket.
 * <li> In general, you can only get a maximum of 250 objects with one API call.
 * <li> You can only update one orderTemplate or order with one API call.
 * </ul>
 * <p>
 * See https://help.shopify.com/api/getting-started/api-call-limit
 */
public class Shopify {

    private final Http http;

    private Configuration configuration;

    private Shopify(String store, String key, String password) {
        configuration = new Configuration(store, key, password);
        http = new Http(configuration);
    }

    public static Shopify getInstance() {
        return new Shopify(
                Constants.SHOPIFY_API_STORE,
                Constants.SHOPIFY_API_KEY,
                Constants.SHOPIFY_API_PASSWORD);
    }

    public OrderTemplate orderTemplate() {
        return new OrderTemplate(http);
    }

    public CustomerTemplate customerTemplate() {
        return new CustomerTemplate(http);
    }

    public static void main(String[] args) {
        Shopify shopify = Shopify.getInstance();
        CustomerList customerList = shopify.customerTemplate().getCustomerByEmail("chao.huang@yahoo.com");

        if (!ObjectUtils.isEmpty(customerList) && !customerList.getCustomers().isEmpty()) {
            Long customerId = customerList.getCustomers().get(0).getId();
            OrderList orderList = shopify.orderTemplate().getOrdersByCustomerId(String.valueOf(customerId));
            System.out.println("Orders: " + orderList);
        }
    }
}
