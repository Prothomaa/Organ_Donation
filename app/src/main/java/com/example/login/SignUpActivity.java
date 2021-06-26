package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    ImageView image ;
    TextView tv1 ,tv2, tv3,tv4 ;
    RadioGroup rdogrp1 , rdogrp2 ;
    //RadioButton rdobtn1 , rdobtn2 ;
    Button go , login ;
    TextInputLayout un , fn;
    TextInputLayout email;
    TextInputLayout phn;
    TextInputLayout dob;
    TextInputLayout pw;
    TextInputLayout cfpw ;
    String gender="" , iden ;
    //FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up2);

        tv1 = findViewById(R.id.logo_name);
        tv2 = findViewById(R.id.slogan_name);
        //tv3 = findViewById(R.id.gender);
        //tv4 = findViewById(R.id.ur);

        go = findViewById(R.id.go);
        login = findViewById(R.id.login);

        fn= findViewById(R.id.name);
        un= findViewById(R.id.username);
        email= findViewById(R.id.email);
        phn= findViewById(R.id.phnNo);
        dob= findViewById(R.id.dob);
        pw= findViewById(R.id.password);
        cfpw= findViewById(R.id.cfpassword);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this , Dashboard.class);
                startActivity(intent);
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaill = email.getEditText().getText().toString();
                String password = pw.getEditText().getText().toString();
                String cfpassword = cfpw.getEditText().getText().toString();
                String user = un.getEditText().getText().toString();
                String phno = phn.getEditText().getText().toString();
                String dobr = dob.getEditText().getText().toString();
                //RadioGroup radioGroup1 = rdogrp1.getCheckedRadioButtonId();



                if(TextUtils.isEmpty(emaill)){
                    email.setError("Required");
                    return;
                }
                else if(TextUtils.isEmpty(password)){
                    pw.setError("Required");
                    return;
                }
                else if(password.length() < 6){
                    pw.setError("Password must be above 6 characters");
                    return;
                }
                else if(TextUtils.isEmpty(cfpassword)){
                    pw.setError("Required");
                    return;
                }

                else if(TextUtils.isEmpty(user)){
                    pw.setError("Required");
                    return;
                }
                else if(TextUtils.isEmpty(phno)){
                    pw.setError("Required");
                    return;
                }
                else if(TextUtils.isEmpty(dobr)){
                    pw.setError("Required");
                    return;
                }


                mAuth.createUserWithEmailAndPassword(emaill,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                           // SignUp signUp= new SignUp( user,emaill,password,dobr);

                            Toast.makeText(SignUpActivity.this,"User created " ,Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),Dashboard.class));

                        }else{
                            Toast.makeText(SignUpActivity.this,"Error ! " +task.getException().getMessage() ,Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
/*
    public void signedUp(View view) {
        String emaill = email.getEditText().getText().toString();
        String password = pw.getEditText().getText().toString();
        String cfpassword = cfpw.getEditText().getText().toString();
        String user = un.getEditText().getText().toString();
        String phno = phn.getEditText().getText().toString();
        String dobr = dob.getEditText().getText().toString();
        //RadioGroup radioGroup1 = rdogrp1.getCheckedRadioButtonId();



        if(TextUtils.isEmpty(emaill)){
            email.setError("Required");
            return;
        }
        else if(TextUtils.isEmpty(password)){
            pw.setError("Required");
            return;
        }
        else if(password.length() < 6){
            pw.setError("Password must be above 6 characters");
            return;
        }
        else if(TextUtils.isEmpty(cfpassword)){
            pw.setError("Required");
            return;
        }

        else if(TextUtils.isEmpty(user)){
            pw.setError("Required");
            return;
        }
        else if(TextUtils.isEmpty(phno)){
            pw.setError("Required");
            return;
        }
        else if(TextUtils.isEmpty(dobr)){
            pw.setError("Required");
            return;
        }

        mAuth = FirebaseAuth.getInstance();
       mAuth.createUserWithEmailAndPassword(emaill,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()){

                   SignUp signUp= new SignUp( user,emaill,password,dobr);

                   Toast.makeText(SignUpActivity.this,"User created " ,Toast.LENGTH_LONG).show();
                   startActivity(new Intent(getApplicationContext(),Dashboard.class));

               }else{
                   Toast.makeText(SignUpActivity.this,"Error ! " +task.getException().getMessage() ,Toast.LENGTH_LONG).show();
               }
           }
       });



    }
*/
}


