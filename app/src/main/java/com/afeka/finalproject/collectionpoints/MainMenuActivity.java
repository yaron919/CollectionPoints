package com.afeka.finalproject.collectionpoints;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainMenuActivity extends AppCompatActivity {

    private User user;
    private FirebaseAuth mAuth;
    private EditText nameET;
    private EditText collectEt;
    private EditText approveEt;
    private EditText declineEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        nameET = (EditText) findViewById(R.id.nameMainActivity);
        collectEt = (EditText) findViewById(R.id.collectedMainActivity);
        approveEt = (EditText) findViewById(R.id.approvedMainActivity);
        declineEt = (EditText) findViewById(R.id.declinedPointsActivity);
        pullUserData();
    }

    void pullUserData(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void showData(DataSnapshot dataSnapshot) {
        String uID = mAuth.getCurrentUser().getUid();
        System.out.println(uID);
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            User user = new User();
            user.setEmail(ds.child(uID).getValue(User.class).getEmail());
            user.setIsAdmin(ds.child(uID).getValue(User.class).getIsAdmin());
            user.setPointsApproved(ds.child(uID).getValue(User.class).getPointsApproved());
            user.setPointsCollected(ds.child(uID).getValue(User.class).getPointsCollected());
            user.setPointsDeclined(ds.child(uID).getValue(User.class).getPointsDeclined());

            nameET.setText(user.getEmail());
            approveEt.setText(("Points approved "+user.getPointsApproved()));
            declineEt.setText("Points declined "+user.getPointsDeclined());
            collectEt.setText("points collected "+user.getPointsCollected());
        }
    }

}
