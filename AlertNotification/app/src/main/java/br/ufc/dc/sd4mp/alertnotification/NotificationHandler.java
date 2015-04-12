package br.ufc.dc.sd4mp.alertnotification;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Debora on 06/04/2015.
 */
public class NotificationHandler extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NotificationManager manager;
        manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(R.string.app_name);
        Toast.makeText(getApplicationContext(), "Notification Handled!!", Toast.LENGTH_SHORT).show();
        finish();
    }

}
