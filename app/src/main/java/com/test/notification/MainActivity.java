package com.test.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Locale;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView image = (ImageView) findViewById(R.id.image);
        final NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        final Resources res = getResources();
        final DisplayMetrics dm = res.getDisplayMetrics();
        final android.content.res.Configuration conf = res.getConfiguration();

        Button en = (Button) findViewById(R.id.buttonEN);
        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conf.locale = new Locale("en");
                res.updateConfiguration(conf, dm);
                NotificationCompat.Builder overdueNotification = new NotificationCompat.Builder(getApplicationContext())
                        .setContentText(getText(R.string.notification_service_content_text))
                        .setSmallIcon(R.drawable.ic_stat);
                overdueNotification.setContentTitle(getText(R.string.notification_service_content_title));
                notificationManager.notify(1, overdueNotification.build());
                image.setImageResource(R.drawable.ic_stat);
                image.setImageResource(R.drawable.ic_launcher);

            }
        });

        Button fa = (Button) findViewById(R.id.buttonFA);
        fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conf.locale = new Locale("fa");
                res.updateConfiguration(conf, dm);
                NotificationCompat.Builder overdueNotification = new NotificationCompat.Builder(getApplicationContext())
                        .setContentText(getText(R.string.notification_service_content_text))
                        .setSmallIcon(R.drawable.ic_stat);
                overdueNotification.setContentTitle(getText(R.string.notification_service_content_title));
                notificationManager.notify(2, overdueNotification.build());
                image.setImageResource(R.drawable.ic_stat);
                image.setImageResource(R.drawable.ic_launcher);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
