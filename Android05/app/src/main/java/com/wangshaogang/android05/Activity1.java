package com.wangshaogang.android05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(Activity1.this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(Activity1.this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(Activity1.this);
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(Activity1.this);
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(Activity1.this);
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(Activity1.this);
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(Activity1.this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button1:
                intent = new Intent(Activity1.this, Activity1.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(Activity1.this, Activity2.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(Activity1.this, Activity3.class);
                startActivity(intent);
                break;
            case R.id.button4:
                intent = new Intent(Activity1.this, Activity4.class);
                startActivity(intent);
                break;
            case R.id.button5:
                intent = new Intent(Activity1.this, Activity5.class);
                startActivity(intent);
                break;
            case R.id.button6:
                intent = new Intent(Activity1.this, Activity6.class);
                startActivity(intent);
                break;
            case R.id.button7:
                intent = new Intent(Activity1.this, Activity7.class);
                startActivity(intent);
                break;

        }
    }
}
