package com.whatsmode.custservice.shopify.order.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsmode.custservice.shopify.common.Constants;
import com.whatsmode.custservice.shopify.fulfillment.response.Fulfillment;

public class Order {
    private long id;

    private String email;

    private String name;

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    private String gateway;

    private String note;

    @JsonProperty(value = "order_number")
    private String orderNumber;

    @JsonProperty(value = "financial_status")
    private String financialStatus;

    @JsonProperty(value = "fulfillment_status")
    private String fulfillmentStatus;

    @JsonProperty(value = "created_at")
    private String createdAt;

    @JsonProperty(value = "updated_at")
    private String updatedAt;

    @JsonProperty(value = "order_status_url")
    private String orderStatusUrl;

    private List<Fulfillment> fulfillments;

    private String latestEventMessage;

    private Map<String, String> fulfillmentMap;

    @JsonProperty(value = "line_items")
    private List<LineItem> lineItems;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(String financialStatus) {
        this.financialStatus = financialStatus;
    }

    public String getFulfillmentStatus() {
        return fulfillmentStatus;
    }

    public void setFulfillmentStatus(String fulfillmentStatus) {
        this.fulfillmentStatus = fulfillmentStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getOrderStatusUrl() {
        return orderStatusUrl;
    }

    public void setOrderStatusUrl(String orderStatusUrl) {
        this.orderStatusUrl = orderStatusUrl;
    }

    public List<Fulfillment> getFulfillments() {
        return fulfillments;
    }

    public void setFulfillments(List<Fulfillment> fulfillments) {
        this.fulfillments = fulfillments;
    }

    public Map<String, String> getFulfillmentMap() {
        return fulfillmentMap;
    }

    public String getLatestEventMessage() {
        return latestEventMessage;
    }

    public void setLatestEventMessage(String latestEventMessage) {
        this.latestEventMessage = latestEventMessage;
    }

    public void setFulfillmentMap() {
        if (fulfillments != null && fulfillments.size() > 0) {
            Map<String, String> map = new HashMap<>();
            for (Fulfillment fulfillment : fulfillments) {
                if(StringUtils.isEmpty(fulfillment.getTrackingUrl())) {
                    map.put(fulfillment.getTrackingNumber(), Constants.DEFAULT_TRACKING_URL + fulfillment.getTrackingNumber());
                } else {
                    map.put(fulfillment.getTrackingNumber(), fulfillment.getTrackingUrl());
                }
            }
            this.fulfillmentMap = map;
        }

    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":" + id
                + ", \"email\":\"" + email + "\""
                + ", \"name\":\"" + name + "\""
                + ", \"gateway\":\"" + gateway + "\""
                + ", \"note\":\"" + note + "\""
                + ", \"orderNumber\":\"" + orderNumber + "\""
                + ", \"financialStatus\":\"" + financialStatus + "\""
                + ", \"fulfillmentStatus\":\"" + fulfillmentStatus + "\""
                + ", \"createdAt\":\"" + createdAt + "\""
                + ", \"updatedAt\":\"" + updatedAt + "\""
                + ", \"orderStatusUrl\":\"" + orderStatusUrl + "\""
                + ", \"fulfillments\":" + fulfillments
                + ", \"latestEventMessage\":\"" + latestEventMessage + "\""
                + ", \"fulfillmentMap\":" + fulfillmentMap
                + "}";
    }
}
