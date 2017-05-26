package com.example.userpc.eventticket;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by user pc on 24-May-17.
 */
public class EventHolder extends RecyclerView.ViewHolder {
    View eView;
    public EventHolder(View itemView) {
        super(itemView);
        eView = itemView;
    }
    public void setEventName(String eventName){
            TextView eventname = (TextView) eView.findViewById(R.id.eventname);
            eventname.setText(eventName);
        }

        public void setEventDate(String eventDate){
            TextView eventdate = (TextView) eView.findViewById(R.id.eventdate);
            eventdate.setText(eventDate);
        }
}
