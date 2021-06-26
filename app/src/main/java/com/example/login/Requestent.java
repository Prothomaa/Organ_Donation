package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Requestent extends AppCompatActivity {

    private ImageView image;
    private TextInputLayout email ,age , organ  ,phn ,date;
    private Button request , show;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Request");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_requestent);

        image = findViewById(R.id.image_b);
        request= findViewById(R.id.request);
        date = findViewById(R.id.date);
        email = findViewById(R.id.email);
        age = findViewById(R.id.age);
        organ = findViewById(R.id.organ_type);
        phn = findViewById(R.id.phone);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Requestent.this,Homepage.class);
                startActivity(intent);
            }
        });


        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mdate = date.getEditText().getText().toString();
                String memail = email.getEditText().getText().toString();
               // String mage = age.getEditText().getText().toString();
                String morgan = organ.getEditText().getText().toString();

                //HashMap<String , String> usermap = new HashMap<>() ;

                Request request = new Request(mdate,memail,morgan);
                root.push().setValue(request);
                Toast.makeText(Requestent.this,"Data Saved" ,Toast.LENGTH_SHORT).show();
            }
        });


        show = findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Requestent.this,Show_donors.class);
                startActivity(intent);
            }
        });


    }
}