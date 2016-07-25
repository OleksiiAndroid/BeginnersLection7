package ua.com.webacademy.beginnerslection7;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.RemoteViews;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    public void OnClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification;

        switch (v.getId()) {
            case R.id.button:
                notification = new NotificationCompat.Builder(this)
                        .setAutoCancel(true).setSmallIcon(R.mipmap.ic_launcher)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setTicker("Notification 1!")
                        .setContentTitle("Notification title 1")
                        .setContentText("Notification text 1")
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent).build();

                notificationManager.notify(1, notification);
                break;
            case R.id.button2:
                notification = new NotificationCompat.Builder(this)
                        .setAutoCancel(true).setSmallIcon(R.mipmap.ic_launcher)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setTicker("Notification 2!")
                        .setContentTitle("Notification title 2")
                        .setContentText("Notification text 2")
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent).build();

                notificationManager.notify(1, notification);
                break;
            case R.id.button3:
                notification = new NotificationCompat.Builder(this)
                        .setAutoCancel(true).setSmallIcon(R.mipmap.ic_launcher)
                        .setDefaults(Notification.DEFAULT_ALL)
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
            case R.id.button5:
                RemoteViews remoteViews = new RemoteViews(this.getPackageName(), R.layout.notification);
                remoteViews.setTextViewText(R.id.textView, "Custom notification");

                notification = new NotificationCompat.Builder(this)
                        .setAutoCancel(true).setSmallIcon(R.mipmap.ic_launcher)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setTicker("Notification!").setContentIntent(pendingIntent)
                        .build();

                notification.contentView = remoteViews;

                notificationManager.notify(3, notification);
                break;
        }
    }
}
