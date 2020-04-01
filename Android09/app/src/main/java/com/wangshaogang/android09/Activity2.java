package com.wangshaogang.android09;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(Activity2.this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(Activity2.this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent intent = new Intent("com.wangshaogang.broadcasttest.MyBROADCAST");
                sendBroadcast(intent);
                break;
            case R.id.button2:
                Intent intent2 = new Intent("com.wangshaogang.broadcasttest.MyBROADCAST");
                sendOrderedBroadcast(intent2, null);
                break;
        }
    }
}
