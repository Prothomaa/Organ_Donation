package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Show_donors extends AppCompatActivity {

    ListView mylistview ;
    //List<Profile> profileList ;
    List<Request> requestList ;

    DatabaseReference root  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_show_donors);

        mylistview=findViewById(R.id.mylistview1);
        //profileList= new ArrayList<>();
        requestList= new ArrayList<>();



       // root = FirebaseDatabase.getInstance().getReference("Profile");
        root = FirebaseDatabase.getInstance().getReference("Request");

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                requestList.clear();
                for(DataSnapshot requestDatasnap : snapshot.getChildren()){

                    Request request = requestDatasnap.getValue(Request.class);
                    requestList.add(request);
                }

                ShowAdapter adapter = new ShowAdapter(Show_donors.this,requestList);
                mylistview.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}