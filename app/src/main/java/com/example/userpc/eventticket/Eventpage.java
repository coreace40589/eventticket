package com.example.userpc.eventticket;

import android.content.Intent;
import android.media.Image;
import android.support.v4.app.Fragment;

/**
 * Created by user pc on 19-May-17.
 */

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Eventpage extends Fragment{

    DatabaseReference eventref= FirebaseDatabase.getInstance().getReference();
    private RecyclerView event_list;
    FirebaseRecyclerAdapter<Events,EventHolder> firebaseRecycleAdapter;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.eventpage  , container, false);

        event_list = (RecyclerView)  rootView.findViewById(R.id.event_list);
        event_list.setHasFixedSize(true);
        event_list.setLayoutManager(new LinearLayoutManager(this.getActivity()));


        firebaseRecycleAdapter = new FirebaseRecyclerAdapter<Events, EventHolder>(Events.class, R.layout.eventlist, EventHolder.class,eventref.child("Events")){
            @Override
            protected void populateViewHolder(EventHolder viewHolder, Events model, final int position) {

                viewHolder.setEventName(model.getEventname());
                viewHolder.setEventDate(model.getEventdate());
                viewHolder.eView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent eventDetail = new Intent(Eventpage.this.getActivity(),Eventdetail.class);
                        eventDetail.putExtra("ID",getRef(position).getKey());
                        startActivity(eventDetail);
                    }
                });
            }
        };
        event_list.setAdapter(firebaseRecycleAdapter);
        return rootView;
    }
}
