package com.example.xieyang.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;

import com.example.xieyang.Config;
import com.example.xieyang.broadcastreceiver.AlarmReceiver;
import com.example.xieyang.utils.Solar;

import java.util.Calendar;

/**
 * Created by Administrator on 2016/8/17.
 */
public class NotifyService extends Service {
    private Solar solar;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("服务开启");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("服务运行");
//        Intent intentL=new Intent();
//        intentL.setAction("com.xieyang.xieyang4");
//        sendBroadcast(intentL);
        System.out.println("----------今天有节日吗???----------"+ Config.HOLDER);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("定时任务--------------------------");
                /**
                 * 发节日通告
                 */
                //时间,早上七点半
                Calendar c = Calendar.getInstance();
                int pushhour = c.get(Calendar.HOUR_OF_DAY);
                int pushminute = c.get(Calendar.MINUTE);
                if (pushhour==10&&pushminute==30) {

                    Intent intent=new Intent();
                    intent.setAction("com.xieyang.xieyang3");
                    sendBroadcast(intent);

                }

            }
        }).start();
        AlarmManager manager= (AlarmManager) getSystemService(ALARM_SERVICE);
        int anHour=60*1000;//一分钟
        long triggerAtTime= SystemClock.elapsedRealtime()+anHour;
        Intent i=new Intent(this, AlarmReceiver.class);
        PendingIntent pi=PendingIntent.getBroadcast(this,0,i,0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pi);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("服务销毁");
    }
}
