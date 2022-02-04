package com.example.ex5_alarm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class alarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context,Intent intent){
        Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Ringtone ringtone=RingtoneManager.getRingtone(context,uri);
        ringtone.play();

        PendingIntent pd=PendingIntent.getActivity(context,0,intent,0);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setContentTitle("Alarm");
        builder.setContentText("Wake up");

        NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());

    }
}
