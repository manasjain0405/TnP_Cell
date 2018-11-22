package com.example.manas.tnp.tpo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class PollListActivity extends AppCompatActivity {

    private PollAdapter poll_adapter;
    private FirebaseDatabase fbDB;
    private DatabaseReference pMessagesDatabaseReference;
    private ChildEventListener pChildEventListner = null;
    private ListView pollListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll_list);

        fbDB = FirebaseDatabase.getInstance();
        pMessagesDatabaseReference = fbDB.getReference().child("PollForm");

        final List<PollForm> poll_item = new ArrayList<>();
        pollListView = findViewById(R.id.poll_list_view);
        poll_adapter= new PollAdapter(this, R.layout.item_poll, poll_item);
        pollListView.setAdapter(poll_adapter);

        attachDatabaseReadListner();

        pollListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PollForm clicked_poll_form = poll_item.get(i);
                Intent web_view = new Intent(PollListActivity.this, PollWebView.class);
                web_view.putExtra("passable_url",clicked_poll_form.getForm_link());
                startActivity(web_view);
            }
        });

    }

    private void attachDatabaseReadListner() {

        if (pChildEventListner == null) {
            pChildEventListner = new ChildEventListener() {

                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    PollForm pollentry = dataSnapshot.getValue(PollForm.class);

                    poll_adapter.add(pollentry);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            };
            pMessagesDatabaseReference.addChildEventListener(pChildEventListner);

        }
    }

    /*private void detachDatabaseReadListener(){

        if(pChildEventListner != null){
            pMessagesDatabaseReference.removeEventListener(pChildEventListner);
            pChildEventListner = null;
        }
    }*/




}
