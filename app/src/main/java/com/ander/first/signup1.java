package com.ander.first;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class signup1 extends AppCompatActivity {

    Button signup;

    EditText user, pass;

    String u_name, u_pass, email;

    ProgressBar probar;

    private FirebaseAuth auth2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);

        init();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                u_name = user.getText().toString().trim();
                u_pass = pass.getText().toString().trim();

                if(u_name.isEmpty() || u_pass.isEmpty())
                {
                    user.setError("Please enter user ID or email");
                    pass.setError("Please enter our password");
                }
                else{
                    probar.setVisibility(View.VISIBLE);
                    createAccount(u_name, u_pass);
                }
            }
        });
    }

    private void createAccount(String email, String password) {
        // [START create_user_with_email]
        auth2.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            sendEmailVerification();
                            startActivity(new Intent(signup1.this, MainActivity2_button.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(signup1.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END create_user_with_email]
    }

    public void init(){
        signup = (Button) findViewById(R.id.signupbtn);
        user = (EditText) findViewById(R.id.suID);
        pass = (EditText) findViewById(R.id.suPWD);
        probar = (ProgressBar) findViewById(R.id.pbar);

        auth2 = FirebaseAuth.getInstance();

    }
    private void updateUI(FirebaseUser user) {

    }

    private void sendEmailVerification() {
        // Send verification email
        // [START send_email_verification]
        final FirebaseUser user = auth2.getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // Email sent
                    }
                });
        // [END send_email_verification]
    }

}



