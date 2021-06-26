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

public class Donate extends AppCompatActivity {

   private ImageView image;
   private TextInputLayout email, name  ,age , organ  ,phn ;
   private Button add;
   private FirebaseDatabase db = FirebaseDatabase.getInstance();
   private DatabaseReference root = db.getReference().child("Profile");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_donate);

        image = findViewById(R.id.imagee);
        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        organ = findViewById(R.id.organ_type);
        phn = findViewById(R.id.phone);
        add = findViewById(R.id.add);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Donate.this,Homepage.class);
                startActivity(intent);
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mname = name.getEditText().getText().toString();
                String memail = email.getEditText().getText().toString();
               // String mage = age.getEditText().getText().toString();
                String morgan = organ.getEditText().getText().toString();

               // HashMap<String , String> usermap = new HashMap<>() ;

                //usermap.put("Name" , mname);
                //usermap.put("Email" , memail);
                //usermap.put("Age" , mage);
                //usermap.put("Organ" , morgan);

                //root.setValue(usermap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    //@Override
                    //public void onComplete(@NonNull Task<Void> task) {
                       // Toast.makeText(Donate.this,"Data Saved" ,Toast.LENGTH_SHORT).show();
                   // }
               // });

               Profile profile = new Profile(memail,mname,morgan);
                root.push().setValue(profile);
                Toast.makeText(Donate.this,"Data Saved" ,Toast.LENGTH_SHORT).show();

            }
        });
    }
}