package com.example.userpc.eventticket;

import android.app.usage.UsageEvents;

/**
 * Created by user pc on 19-May-17.
 */
public class Events {
    public String id;
    public String eventname;
    public String eventdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public Events(String id, String eventname, String eventdate) {

        this.id = id;
        this.eventname = eventname;
        this.eventdate = eventdate;
    }

    public Events(){

    }
}
