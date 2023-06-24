package com.ander.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3_calc extends AppCompatActivity {

    private int cCounter = 0;

    Button btn2, btn4;
    EditText num1, num2;

    String x, y;

    TextView t1, t2, t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_calc);

        btn2 = (Button) findViewById(R.id.calc);
        btn4 = (Button) findViewById(R.id.res);
        num1 = (EditText) findViewById(R.id.firstnumber);
        num2 = (EditText) findViewById(R.id.secondnumber);
        t1 = (TextView) findViewById(R.id.store1);
        t2 = (TextView) findViewById(R.id.store2);
        t3 = (TextView) findViewById(R.id.store3);



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                x = num1.getText().toString();
                y = num2.getText().toString();

                if(x.isEmpty() || y.isEmpty()){
                    num1.setError("Please enter a number");
                    num2.setError("Please enter a number");
                }
                else{
                    String data1 = num1.getText().toString();
                    String data2 = num2.getText().toString();

                    char c1 = data1.charAt(0);
                    char c2 = data2.charAt(0);

                    if (((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z')) || ((c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z'))){
                        Toast.makeText(MainActivity3_calc.this, "Numbers only", Toast.LENGTH_LONG).show();
                    }
                    else{
                        int i = Integer.parseInt(x);
                        int o = Integer.parseInt(y);
                        int p = i + o;
                        t1.setText("The sum is: " +p);

                        int q = 1 + cCounter ++;
                        int w = q * p;
                        t2.setText("Click Multiplier: " +w);
                        t3.setText("Number of clicks: "+q);
                    }

                    }
                }


            });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity3_calc.this, MainActivity3_calc.class);
                finish();
                startActivity(intent3);
            }
        });
        };


    }
