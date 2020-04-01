/**
 * Created by 王少刚 on 2018/11/1.
 */

package com.wangshaogang.android06;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout implements View.OnClickListener {
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);

        Button title_back = (Button) findViewById(R.id.title_back);
        title_back.setOnClickListener(TitleLayout.this);
        Button title_forward = (Button) findViewById(R.id.title_forward);
        title_forward.setOnClickListener(TitleLayout.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                ((Activity)getContext()).finish();
                break;
            case R.id.title_forward:
                Toast.makeText(getContext(), "You clicked \"Forward\"", Toast.LENGTH_SHORT).show();

        }
    }
}
