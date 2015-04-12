package br.ufc.dc.sd4mp.alertnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.Toast;


/**
 * Created by Debora on 06/04/2015.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED))
        {
            if(MainActivity.options[0] == 1)
            {

                createNotification(1,context,"Notification","AlertNotification","Bateria mudou!");
            }
        }

        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        {
            if(MainActivity.options[1] == 1)
            {

                createNotification(2,context,"Notification","AlertNotification"," Modo Avião mudou!");
            }
        }

        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED))
        {
            if(MainActivity.options[2] == 1)
            {
                createNotification(3,context,"Notification","AlertNotification","Carregador Conectou!");
            }
        }

        if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED))
        {
            if(MainActivity.options[3] == 1)
            {
                createNotification(4,context,"Notification","AlertNotification","Carregador Desconectou!");
            }
        }

    }

    protected void createNotification(int icon, Context context,String status, String title, String content) {
        NotificationManager manager;
        manager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setTicker(status);
        builder.setContentTitle(title);
        builder.setContentText(content);
        if(icon == 1)
            builder.setSmallIcon(R.drawable.icon1);

        if(icon == 2)
            builder.setSmallIcon(R.drawable.icon2);

        if(icon == 3)
            builder.setSmallIcon(R.drawable.icon3);

        if(icon == 4)
            builder.setSmallIcon(R.drawable.icon4);
        Intent intent = new Intent(context, NotificationHandler.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent, 0);
        builder.setContentIntent(pIntent);
        Notification notification = builder.build();
        manager.notify(R.string.app_name, notification);
    }

}
