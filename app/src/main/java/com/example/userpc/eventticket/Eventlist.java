package com.example.userpc.eventticket;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user pc on 19-May-17.
 */
public class Eventlist extends ArrayAdapter<Eventlist> {
    private Activity context;
    List<Eventlist> eventlist;

    public Eventlist(Activity context, List<Eventlist> eventlist) {
        super(context, R.layout.eventpage, eventlist);
        this.context = context;
        this.eventlist = eventlist;
    }



}
