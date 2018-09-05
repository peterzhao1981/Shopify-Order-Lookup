package com.whatsmode.custservice.shopify.event.response;

import java.util.List;

/**
 * Created by zhaoweiwei on 2018/8/30.
 */
public class EventList {

    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "{"
                + "\"events\":" + events
                + "}";
    }
}
