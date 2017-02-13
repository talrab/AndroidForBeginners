package com.example.myapplication1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by tal on 13/02/2017.
 */

public class TheService extends Service {


    final class TheThread implements Runnable{
        int serviceId;
        TheThread (int serviceId){
            this.serviceId = serviceId;
        }

        @Override
        public void run() {
            synchronized (this){
                try {
                    wait(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stopSelf(this.serviceId);    // this will call onDestroy()
            }
        }
    }



    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(TheService.this,"Service Started",Toast.LENGTH_LONG).show();
//        synchronized (this){
//            try {                                         // Option A - the app will get blocked because it is in the same main thread
//                wait(20000);                              //simulating a long operation which block the service for 20 seconds
//            } catch (InterruptedException e) {            // if we haven't commented this out and used this code instead of the thread
//                e.printStackTrace();                      // implemented above, the app would have been blocked for 20 sec. this why we are
//            }                                             // implemewnting the thread above to overcome this.
//        }

        Thread thread = new Thread(new TheThread(startId));    // Option B - using a thread so the app will not get blocked
        thread.start();

        return START_STICKY ;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(TheService.this,"Service Destroyed",Toast.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
