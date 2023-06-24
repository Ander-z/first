package com.ander.first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgot extends AppCompatActivity {

    EditText email;
    Button rst;
    ProgressBar probar2;

    String a, emailadd;

    FirebaseAuth auth3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        email = (EditText) findViewById(R.id.remail);
        rst = (Button) findViewById(R.id.reset);
        probar2 = (ProgressBar) findViewById(R.id.pbar2);

        auth3 = FirebaseAuth.getInstance();

        rst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a = email.getText().toString().trim();

                if(a.isEmpty())
                {
                    email.setError("Please enter user ID or email");
                }
                else{

                    emailadd = a;

                    probar2.setVisibility(View.VISIBLE);

                    auth3.sendPasswordResetEmail(emailadd)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {

                                        Toast.makeText(forgot.this, "Email sent successfully", Toast.LENGTH_SHORT).show();

                                        startActivity(new Intent(forgot.this, MainActivity2_button.class));
                                    }
                                }
                            });
                }

            }
        });


    }


}