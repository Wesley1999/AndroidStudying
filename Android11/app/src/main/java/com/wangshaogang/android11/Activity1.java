package com.wangshaogang.android11;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Button send_notice = (Button) findViewById(R.id.send_notice);
        send_notice.setOnClickListener(Activity1.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                Intent intent = new Intent(this, Activity2.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);

                NotificationManager manager = (NotificationManager) getSystemService((NOTIFICATION_SERVICE));
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is title")
                        .setContentText("This is short Text.")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.jf)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.jf))
                        .setContentIntent(pi)
                        .setAutoCancel(true)
//                        .setStyle(new NotificationCompat.BigTextStyle().bigText("This is Text. " +
//                                "This is Text. This is Text. This is Text. This is Text. "))
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(
                                BitmapFactory.decodeResource(getResources(),R.drawable.jfb)))
                        .setPriority(Notification.PRIORITY_MAX)
                        .build();
                manager.notify(1, notification);

                break;
        }
    }
}
