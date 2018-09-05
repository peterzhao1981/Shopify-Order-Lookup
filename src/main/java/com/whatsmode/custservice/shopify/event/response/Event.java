package com.whatsmode.custservice.shopify.event.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by zhaoweiwei on 2018/8/30.
 */
public class Event {

    private long id;

    @JsonProperty(value = "created_at")
    private String createdAt;

    private String message;

    private String author;

    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":" + id
                + ", \"createdAt\":\"" + createdAt + "\""
                + ", \"message\":\"" + message + "\""
                + ", \"author\":\"" + author + "\""
                + ", \"description\":\"" + description + "\""
                + "}";
    }
}
