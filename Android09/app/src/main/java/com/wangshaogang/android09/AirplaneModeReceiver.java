package com.wangshaogang.android09;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "AirplaneMode ON/OFF", Toast.LENGTH_LONG).show();
        Log.d("AIRPLANE_MODE", "AirplaneMode ON/OFF");
    }
}
