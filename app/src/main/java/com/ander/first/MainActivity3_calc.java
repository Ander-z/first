package com.ander.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3_calc extends AppCompatActivity {

    private int cCounter = 0;

    Button btn2, btn4;

    EditText num1, num2;

    String x, y;

    Integer i, o, p, q, w, e;

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
                    int i = Integer.parseInt(x);
                    int o = Integer.parseInt(y);
                    int p = i + o;
                    t1.setText("The sum is: " +p);

                    int q = 1 + cCounter ++;
                    int w = q * p;
                    t2.setText("Click Multiplier: " +w);
                    t3.setText("Nummber of clicks: "+q);
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