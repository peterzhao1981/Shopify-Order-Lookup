package com.whatsmode.custservice.shopify.customer.template;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.whatsmode.custservice.shopify.customer.response.CustomerList;
import com.whatsmode.custservice.shopify.util.Http;

public class CustomerTemplate {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Http http;

    public CustomerTemplate(Http http) {
        this.http = http;
    }

    /**
     * Get customers by customer email - e.g. foo@bar.com
     *
     * @param email
     * @return
     */
    public CustomerList getCustomerByEmail(String email) {

        if (StringUtils.isEmpty(email)) {
            logger.error("invalid parameter - email is null");
            throw new IllegalArgumentException("invalid parameter - email is null");
        }

        return findCustomers(Collections.singletonMap("query", "email:" + email));
    }

    /**
     * Retrieve a list of products. Return null if empty results or the number of results exceeded limit - 250.
     *
     * @param queryParams
     * @return
     */
    private CustomerList findCustomers(Map<String, String> queryParams) {
        return http.getForObject("/admin/customers/search.json", CustomerList.class, queryParams);
    }

}
