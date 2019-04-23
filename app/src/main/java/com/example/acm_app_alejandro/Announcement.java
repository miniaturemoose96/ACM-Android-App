package com.example.acm_app_alejandro;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class Announcement {
    // Firebase
    final private FirebaseDatabase database = FirebaseDatabase.getInstance();

    //Instance of our database
    private DatabaseReference mDatabaseRefence;

    // Anouncements List
    private List<Announcement> mAnnouncement;

    private String title;
    private String author;
    private String body;
    private String date;
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Announcement(){}

    // Create method that retrieves our data
    public void retrieveData(){
        // Get database reference from firebase
        mDatabaseRefence = database.getReference();
        // Set child of the root
        Query query = mDatabaseRefence.child("Announcements");
        // In order to listen for changes, add a listener
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    Announcement announcement = singleSnapshot.getValue(Announcement.class);
                    mAnnouncement.add(announcement);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
