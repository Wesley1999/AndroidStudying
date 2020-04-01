package com.wangshaogang.android02;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "你选择了“Add”菜单",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "你选择了“Remove”菜单",
                        Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "你点了“这是个按钮”",
                        Toast.LENGTH_SHORT).show();
            }
        });

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(FirstActivity.this, "销毁成功",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // 显式Intent
        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
                Toast.makeText(FirstActivity.this, "点击返回键可以返回原来的活动\n（返回键也会销毁当前活动）",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // 隐式Intent
        Button button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 进入满足这两个条件的活动
                Intent intent = new Intent("com.wangshaogang.android02.ACTION_START");
                intent.addCategory("android.intent.category.DEFAULT");
                startActivity(intent);
                Toast.makeText(FirstActivity.this, "点击返回键可以返回原来的活动\n（返回键也会销毁当前活动）",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // 进入wangshaogang.com
        Button button5 = (Button) findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.wangshaogang.com"));
                startActivity(intent);
            }
        });

        // 打电话
        Button button6 = (Button) findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:13207123727"));
                startActivity(intent);
            }
        });

        // 向下一个活动传数据
        Button button7 = (Button) findViewById(R.id.button_7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "看到这条toast说明数据传过来了！";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                // 传数据
                intent.putExtra("extra_data", data);
                startActivity(intent);
                Toast.makeText(FirstActivity.this, "数据已经传过去了",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // 下一个活动返回传数据（带请求码）
        Button button8 = (Button) findViewById(R.id.button_8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        // 这是没收到带指定请求码的回传数据的情况
        Button button9 = (Button) findViewById(R.id.button_9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this,
                        "没收到回传的数据",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    final String returnData = data.getStringExtra("data_return");
                    Button button9 = (Button) findViewById(R.id.button_9);
                    button9.setOnClickListener(new View.OnClickListener() {
                        // 查看回传数据（带指定请求码才显示）
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(FirstActivity.this,
                                    returnData,
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                break;
            default:
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(FirstActivity.this, "抱歉，并不能退出！",
                Toast.LENGTH_SHORT).show();
    }

}
