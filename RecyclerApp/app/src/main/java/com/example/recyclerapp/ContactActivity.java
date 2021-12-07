package com.example.recyclerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    List<Contact> contacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        String url = "https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg";
        contacts.add(new Contact("Jean0", "Peirre", "https://img-19.ccm2.net/cI8qqj-finfDcmx6jMK6Vr-krEw=/1500x/smart/b829396acc244fd484c5ddcdcb2b08f3/ccmcms-commentcamarche/20494859.jpg"));
        contacts.add(new Contact("Jean1", "Peirre", url));
        contacts.add(new Contact("Jean2", "Peirre", url));
        contacts.add(new Contact("Jean3", "Peirre", url));
        contacts.add(new Contact("Jean4", "Peirre", url));
        contacts.add(new Contact("Jean5", "Peirre", url));
        contacts.add(new Contact("Jean6", "Peirre", url));
        contacts.add(new Contact("Jean7", "Peirre", url));

        ContactsAdapter adapter = new ContactsAdapter(contacts);

        rvContacts.setAdapter(adapter);

        rvContacts.setLayoutManager(new LinearLayoutManager(this));

    }
}