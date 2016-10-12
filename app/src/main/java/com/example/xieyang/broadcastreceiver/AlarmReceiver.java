package com.example.xieyang.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.xieyang.service.NotifyService;

/**
 * Created by Administrator on 2016/8/17.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i=new Intent(context, NotifyService.class);
        context.startService(i);
    }
}
