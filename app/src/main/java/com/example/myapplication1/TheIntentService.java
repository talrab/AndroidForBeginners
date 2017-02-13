package com.example.myapplication1;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by tal on 13/02/2017.
 */

public class TheIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public TheIntentService() {
        super("Tal's_Intent_thread_service");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(TheIntentService.this,"Intent Service Started", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(TheIntentService.this,"Intent Service Destroyed", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent intent) {  //this service will stop itself when it is done.
        synchronized (this){
            try {
                wait(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
