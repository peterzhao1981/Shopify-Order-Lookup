package com.whatsmode.custservice.shopify.event.template;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.whatsmode.custservice.shopify.event.response.EventList;
import com.whatsmode.custservice.shopify.util.Http;

/**
 * Created by zhaoweiwei on 2018/8/30.
 */
public class EventTemplate {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Http http;

    public EventTemplate(Http http) {
        this.http = http;
    }

    /**
     * Get events by order id - e.g. #41156789
     *
     * @param orderId
     * @return
     */
    public EventList getLatestEventByOrderId(long orderId) {

        if (StringUtils.isEmpty(orderId)) {
            logger.error("invalid parameter - orderId is null");
            throw new IllegalArgumentException("invalid parameter - orderId is null");
        }
        String path = "/admin/orders/" + orderId + "/events.json";

        return findEvents(path, buildQueryParams());
    }

    /**
     * Retrieve a list of products. Return null if empty results or the number of results exceeded limit - 250.
     *
     * @param queryParams
     * @return
     */
    private EventList findEvents(String path, Map<String, String> queryParams) {
        return http.getForObject(path, EventList.class, queryParams);
    }

    private Map<String, String> buildQueryParams() {
        Map<String, String> params = new HashMap<>();

        params.put("limit", "1");
        params.put("page", "1");

        return params;
    }

}
