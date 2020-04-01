package com.wangshaogang.android02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    //重写返回键，使其与下面的按钮1功能相同
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "看到这条toast说明数据回传成功了！");
        setResult(RESULT_OK, intent);
        finish();
        Toast.makeText(SecondActivity.this, "回传并销毁成功",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "看到这条toast说明数据回传成功了！");
                setResult(RESULT_OK, intent);
                finish();
                Toast.makeText(SecondActivity.this, "回传并销毁成功",
                        Toast.LENGTH_SHORT).show();
            }
        });



        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String data = intent.getStringExtra("extra_data");
                if (data == null) {
                    data = "没有接收到任何数据，请传入数据！";
                }
                Toast.makeText(SecondActivity.this, data,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
