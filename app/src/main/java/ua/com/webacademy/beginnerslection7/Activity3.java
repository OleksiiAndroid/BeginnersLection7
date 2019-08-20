package ua.com.webacademy.beginnerslection7;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class Activity3 extends AppCompatActivity {

    private static final String CHANNEL_ID = "ua.com.webacademy.beginnerslection7.channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    public void OnClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder;
        Notification notification;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Default channel", NotificationManager.IMPORTANCE_HIGH);

            channel.enableLights(true);
            channel.enableVibration(true);
            channel.setLightColor(Color.RED);
            channel.setShowBadge(true);
            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

            notificationManager.createNotificationChannel(channel);


            builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        } else {
            builder = new NotificationCompat.Builder(this);
            builder.setDefaults(Notification.DEFAULT_ALL);
        }

        switch (v.getId()) {
            case R.id.button:
                notification = builder
                        .setAutoCancel(true).setSmallIcon(R.mipmap.ic_launcher)
                        .setTicker("Notification 1!")
                        .setContentTitle("Notification title 1")
                        .setContentText("Notification text 1")
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent).build();

                notificationManager.notify(1, notification);
                break;
            case R.id.button2:
                notification = builder
                        .setAutoCancel(true).setSmallIcon(R.mipmap.ic_launcher)
                        .setTicker("Notification 2!")
                        .setContentTitle("Notification title 2")
                        .setContentText("Notification text 2")
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent).build();

                notificationManager.notify(1, notification);
                break;
            case R.id.button3:
                notification = builder
                        .setAutoCancel(true).setSmallIcon(R.mipmap.ic_launcher)
                        .setTicker("Notification 3!")
                        .setContentTitle("Notification title 3")
                        .setContentText("Notification text 3")
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent).build();

                notificationManager.notify(2, notification);
                break;
            case R.id.button4:
                notificationManager.cancel(1);
                notificationManager.cancel(2);
                break;
        }
    }
}
