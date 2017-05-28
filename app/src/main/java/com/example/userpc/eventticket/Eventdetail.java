package com.example.userpc.eventticket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by user pc on 24-May-17.
 */
public class Eventdetail extends AppCompatActivity {
    //DatabaseReference eventref= FirebaseDatabase.getInstance().getReference().child("Events");
    DatabaseReference eventref= FirebaseDatabase.getInstance().getReference("Events");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventdetail);

        Intent intent = getIntent();
        String eventId = intent.getStringExtra("ID");
        Log.d("EVENT ID",""+eventId);

        final TextView eventNameTxt = (TextView)findViewById(R.id.eventdetail_eventname);
        final TextView eventDateTxt = (TextView)findViewById(R.id.eventdetail_eventdate);

        eventref.child(eventId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Events eventdata = dataSnapshot.getValue(Events.class);
                String eventname = eventdata.getEventname();
                String eventdate = eventdata.getEventdate();

                eventNameTxt.setText("Event Name : "+eventname);
                eventDateTxt.setText("Date : "+eventdate);
            }
            
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("","Data not Exist/Error :"+databaseError);
            }
        });
    }



}
