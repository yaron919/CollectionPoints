package com.afeka.finalproject.collectionpoints;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainMenuActivity extends AppCompatActivity {

    private String userId;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }

    void pullUserData(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users");
       // StringmAuth.getCurrentUser()
    }
}
