package com.ander.first;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class MainActivity2_button extends AppCompatActivity {

    Button btn;
    EditText user3, pass;

    TextView sup, forg;
    String a, b;

    private FirebaseAuth auth1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_button);

        init1();

        try {
            String data = auth1.getCurrentUser().getEmail();

            assert data != null;
            if (!data.equals(""))
                startActivity(new Intent(MainActivity2_button.this, MainActivity.class));
                finish();
        } catch (Exception e) {
            Toast.makeText(this, "You are not Logged in", Toast.LENGTH_SHORT).show();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a = user3.getText().toString().trim();
                b = pass.getText().toString().trim();

            if(a.isEmpty() || b.isEmpty())
            {
                user3.setError("Please enter user ID or email");
                pass.setError("Please enter our password");
            }
            else{
                signIn(a, b);
            }

               // Intent intent = new Intent(MainActivity2_button.this,MainActivity.class);
               // startActivity(intent);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity2_button.this, signup1.class));

            }
        });

        forg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2_button.this, forgot.class));
            }
        });


    }

    private void signIn(String email, String password){
        // [START sign_in_with_email]
        auth1.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = auth1.getCurrentUser();
                            updateUI(user);
                            startActivity(new Intent(MainActivity2_button.this, MainActivity.class));
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity2_button.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });


    }

    public void init1(){

        btn = (Button) findViewById(R.id.login);
        sup = (TextView) findViewById(R.id.signup);
        user3 = (EditText) findViewById(R.id.userID);
        pass = (EditText) findViewById(R.id.password);
        forg = (TextView) findViewById(R.id.forgTV);

        auth1 = FirebaseAuth.getInstance();

    }

    private void updateUI(FirebaseUser user) {

    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity2_button.this);

        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Are you sure you want to exit?");
        alertDialog.setIcon(R.drawable.baseline_warning_amber_24);
        alertDialog.setCancelable(false);

        alertDialog.setNeutralButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alert = alertDialog.create();
        alert.show();

    }

}
