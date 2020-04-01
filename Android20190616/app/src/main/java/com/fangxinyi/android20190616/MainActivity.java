package com.fangxinyi.android20190616;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created on 2019/6/16.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, "users", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.login);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                // 获取输入的数据
                EditText usernameEditText = (EditText) findViewById (R.id.username);
                String username = usernameEditText.getText().toString();
                EditText passwordEditText = (EditText) findViewById (R.id.password);
                String password = passwordEditText.getText().toString();

                // 校验输入
                if (username.equals("")) {
                    Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (password.equals("")) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                    break;
                }

                MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, "users", null, 1);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.rawQuery("select * from users where username = ?", new String[]{username});

                if (!cursor.moveToFirst()) {
                    Toast.makeText(this, "用户名不存在", Toast.LENGTH_SHORT).show();
                    break;
                }

                String correctPassword = cursor.getString(cursor.getColumnIndex("password"));

                if (password.equals(correctPassword)) {
                    Intent intent = new Intent(this, SuccessActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
