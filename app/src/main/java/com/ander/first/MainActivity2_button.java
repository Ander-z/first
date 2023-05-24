package com.ander.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2_button extends AppCompatActivity {

    Button btn;
    EditText user, pass;
    String a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_button);

        btn = (Button) findViewById(R.id.login);
        user = (EditText) findViewById(R.id.userID);
        pass = (EditText) findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a = user.getText().toString();
                b = pass.getText().toString();

            String msg = "ID:"+a+"\nPassword:";



            if(a.isEmpty() || b.isEmpty())
            {
                user.setError("Please enter user ID or email");
                pass.setError("Please enter our password");
            }
            else{
                //Toast.makeText(MainActivity2_button.this, msg, Toast.LENGTH_LONG).show();
                if(a.equals("ander632") && b.equals("00000000")){
                    Intent intent = new Intent(MainActivity2_button.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    user.setError("Wrong Credentials");
                    pass.setError("Wrong Credentials");
                }
            }

               // Intent intent = new Intent(MainActivity2_button.this,MainActivity.class);
               // startActivity(intent);
            }
        });


    }
}