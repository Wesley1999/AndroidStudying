package com.wangshaogang.android06;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        // 隐藏原本的标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

//        Button title_back = (Button) findViewById(R.id.title_back);
//        title_back.setOnClickListener(Activity1.this);
        Button title_forward = (Button) findViewById(R.id.title_forward);
        title_forward.setOnClickListener(Activity1.this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.title_back:
//                Toast.makeText(Activity1.this, "You clicked \"Back\"", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.title_forward:
                Intent intent = new Intent(Activity1.this, Activity1.class);
                startActivity(intent);
                break;

        }
    }
}
