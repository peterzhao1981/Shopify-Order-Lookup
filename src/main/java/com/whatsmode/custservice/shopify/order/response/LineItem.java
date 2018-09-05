package com.whatsmode.custservice.shopify.order.response;

/**
 * Created by zhaoweiwei on 2018/9/3.
 */
public class LineItem {

    private long id;

    private String title;

    private String sku;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":" + id
                + ", \"title\":\"" + title + "\""
                + ", \"sku\":\"" + sku + "\""
                + "}";
    }
}
