package com.zuo.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.elvishew.xlog.XLog;
import com.zuo.server.binder.SendMessage;

public class HandleRequiredService extends Service {

    public HandleRequiredService() {
        XLog.d("new HandleRequiredService");
    }

    private IBinder binder = new SendMessage();

    @Override
    public void onCreate() {
        super.onCreate();
        XLog.d("拉起service");
    }

    @Override
    public IBinder onBind(Intent intent) {
        XLog.d("onBind");
        XLog.d("intent Action" + intent.getAction());
        return binder;
    }
}
