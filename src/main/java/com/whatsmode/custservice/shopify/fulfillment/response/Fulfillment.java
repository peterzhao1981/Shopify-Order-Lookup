package com.whatsmode.custservice.shopify.fulfillment.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by zhaoweiwei on 2018/8/30.
 */
public class Fulfillment {
    private long id;

    @JsonProperty(value = "order_id")
    private String orderId;

    private String status;

    @JsonProperty(value = "tracking_number")
    private String trackingNumber;

    @JsonProperty(value = "tracking_numbers")
    private List<String> trackingNumbers;

    @JsonProperty(value = "tracking_url")
    private String trackingUrl;

    @JsonProperty(value = "tracking_urls")
    private List<String> trackingUrls;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public List<String> getTrackingNumbers() {
        return trackingNumbers;
    }

    public void setTrackingNumbers(List<String> trackingNumbers) {
        this.trackingNumbers = trackingNumbers;
    }

    public String getTrackingUrl() {
        return trackingUrl;
    }

    public void setTrackingUrl(String trackingUrl) {
        this.trackingUrl = trackingUrl;
    }

    public List<String> getTrackingUrls() {
        return trackingUrls;
    }

    public void setTrackingUrls(List<String> trackingUrls) {
        this.trackingUrls = trackingUrls;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":" + id
                + ", \"orderId\":\"" + orderId + "\""
                + ", \"status\":\"" + status + "\""
                + ", \"trackingNumber\":\"" + trackingNumber + "\""
                + ", \"trackingNumbers\":" + trackingNumbers
                + ", \"trackingUrl\":\"" + trackingUrl + "\""
                + ", \"trackingUrls\":" + trackingUrls
                + "}";
    }
}
