package com.wangshaogang.android04;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    private ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar2 = (ProgressBar) findViewById(R.id.progress_bar2);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String inputText = editText.getText().toString();
                Toast.makeText(Activity1.this, inputText, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                imageView.setImageResource(R.drawable.w20181030225835);
                break;
            case R.id.button3:
                switch (progressBar.getVisibility()) {
                    case View.VISIBLE:
                        progressBar.setVisibility(View.INVISIBLE);
                        break;
                    case View.INVISIBLE:
                        progressBar.setVisibility(View.GONE);
                        break;
                    case View.GONE:
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case R.id.button4:
                progressBar2.setProgress(progressBar2.getProgress() + 5);
                break;
            case R.id.button5:
                AlertDialog.Builder dialog = new AlertDialog.Builder(Activity1.this);
                dialog.setTitle("This is an AlertDialog");
                dialog.setMessage("This is something Important!\nYou cannot use Back!");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Activity1.this, "You clicked \"OK\".",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Activity1.this, "You clicked \"Cancel\".",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
                break;
            case R.id.button6:
                ProgressDialog progressDialog = new ProgressDialog(Activity1.this);
                progressDialog.setTitle("This is a ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;

        }
    }
}

