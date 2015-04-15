package br.ufc.dc.sd4mp.startedsevicelifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by 0333399 on 15/04/15.
 */
public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("lifecycle",getClass().getName()+" onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //return super.onStartCommand(intent, flags, startId);
        Log.i("lifecycle",getClass().getName()+" onStartCommand()");
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("lifecycle",getClass().getName()+" onBind()");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i("lifecycle",getClass().getName()+" onDestroy()");
        super.onDestroy();
    }
}
