package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.view.View.*;

public class Dashboard extends AppCompatActivity {

    Button call_signUp , login , frg_pass;
    TextView logoText , sloganText ;
    TextInputLayout email , p_word ;
      //mAuth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dashboard);


        call_signUp =(Button) findViewById(R.id.sign_Up);
        login =(Button) findViewById(R.id.go);
        frg_pass = findViewById(R.id.frgpassword);
        logoText = findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        email= findViewById(R.id.email);
        p_word = findViewById(R.id.password);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();



        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_l = email.getEditText().getText().toString();
                String password = p_word.getEditText().getText().toString();

                if(TextUtils.isEmpty(email_l)){
                    email.setError("Required");
                    return;
                }
                else if(TextUtils.isEmpty(password)){
                    p_word.setError("Required");
                    return;
                }
                else if(password.length() < 6){
                    p_word.setError("Password must be above 6 characters");
                    return;
                }
               // Intent intent = new Intent(Dashboard.this, Homepage.class);
                //startActivity(intent);

              mAuth.signInWithEmailAndPassword(email_l,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Dashboard.this,"Logged In",Toast.LENGTH_LONG).show();
                            //startActivity(new Intent(getApplicationContext(),Profile.class));
                           Intent intent = new Intent(Dashboard.this, Homepage.class);
                           startActivity(intent);
                       }
                        else {
                            Toast.makeText(Dashboard.this,"Error !",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        }) ;





        call_signUp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this ,SignUpActivity.class);
                startActivity(intent);
            }
        });

        frg_pass.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText resetmail = new EditText(v.getContext());
                AlertDialog.Builder passresdialog = new AlertDialog.Builder(v.getContext());
                passresdialog.setTitle("Reset Password ?");
                passresdialog.setMessage("Enter your Email ");
                passresdialog.setView(resetmail);

                passresdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String mail = resetmail.getText().toString();
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Dashboard.this,"Reset Link Send to your Mail",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Dashboard.this,"ERROR ! "+e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                passresdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                passresdialog.create().show();
            }
        });

    }


}