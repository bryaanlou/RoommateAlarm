package com.example.andrew.fkyouralarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.media.RingtoneManager;
import android.media.Ringtone;
import android.view.View;
import android.widget.PopupMenu;

import com.google.firebase.database.*;
/**
 * Created by andrew on 11/12/2016.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent)
    {

        System.out.println("WFFFF");
        Uri notification = Uri.parse(intent.getStringExtra("rturi"));
        String s = intent.getStringExtra("desc");
        final Ringtone r = RingtoneManager.getRingtone(context, notification);
        r.play();
        View v = new View(context);

        PopupMenu pop = new PopupMenu(context, v);

        DatabaseReference mRoofRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference mConditionalRef = mRoofRef.child("condition");
        mConditionalRef.setValue("alarm");
        mConditionalRef.addValueEventListener((new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text =  dataSnapshot.getValue(String.class);
                if (text.equals("STOP"))    {
                    //stop the alarm
                    System.out.println("here");
                    r.stop();
                }
                else if(text.equals("START"))   {
                    //start the alarm
                    System.out.println("there");
                    r.play();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }));

    }

}
