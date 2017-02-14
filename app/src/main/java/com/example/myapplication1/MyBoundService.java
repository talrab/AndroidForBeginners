 package com.example.myapplication1;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;


 /*
 BOUND SERVICES
 A bound service is the server in a client-server interface. A bound service allows components
 (such as activities) to bind to the server, send requests, receive responses and even perform
 interprocess communication (IPC)

 CREATING A BOUND SERVICE
 Extending the binder class - if your service is private to your own application and runs in the
 same process as the client (which is common), you should create your interface by extending the Binder class
 and returning an instance of it from onBind()
  */


public class MyBoundService extends Service {

    private final IBinder iBinder = new LocalBinder();
    private final Random mGenerator = new Random();

//this is the class we wrote which extends the Binder class and has a getService method.
    public class LocalBinder extends Binder{
        MyBoundService getService (){
            return MyBoundService.this;
        }
    }

    public MyBoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public int getRandom(){
        return mGenerator.nextInt(200);
    }


}
