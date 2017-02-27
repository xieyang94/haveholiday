package com.example.xieyang.broadcastreceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.example.administrator.demo3.MainActivity;
import com.example.administrator.demo3.R;
import com.example.xieyang.Config;
import com.example.xieyang.utils.ShowLog;

import java.util.Calendar;

/**
 * 广播通知有节日
 */
public class NotifyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Calendar c = Calendar.getInstance();
        int nyear=c.get(Calendar.YEAR);
        int nmonth=c.get(Calendar.MONTH)+1;//国际日历从0到11月
        int nday=c.get(Calendar.DAY_OF_MONTH);

        ShowLog.showTag("----------今天有节日吗？----------"+Config.HOLDER);

        if (Config.DAY ==nday&& Config.YEAR == nyear&& Config.MONTH == nmonth&&Config.HOLDER==true) {
            ShowLog.showTag("有节日");

            RemoteViews contentView = new RemoteViews(context.getPackageName(), R.layout.style_notification);
            contentView.setImageViewResource(R.id.image, R.drawable.icon_notifycation);
            contentView.setTextViewText(R.id.title, "有节日");
            contentView.setTextViewText(R.id.text, "今天又有节日了");

            PendingIntent pt=PendingIntent.getActivity(context, 1, new Intent(context,MainActivity.class), 0);
            Notification notice = new Notification.Builder(context)
                    .setAutoCancel(true)
//                    .setContentTitle("有节日")
//                    .setContentText("今天又有节日了")
                    .setContentIntent(pt)
                    .setSmallIcon(R.drawable.icon_notifycation)
                    .setAutoCancel(true)
                    .setContent(contentView)
                    .setWhen(System.currentTimeMillis()).getNotification();
            //Call requires API level 16(current min is 14):android.app.Notification.Builder#build
            // 系统默认设置（震动，铃声等等）
            notice.defaults=Notification.DEFAULT_ALL;

            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            manager.notify(100, notice);

        }else{
            ShowLog.showTag("没节日");
        }
    }
}
