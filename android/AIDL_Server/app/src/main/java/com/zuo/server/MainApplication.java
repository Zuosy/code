package com.zuo.server;

import android.app.Application;

import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogConfiguration configuration = new LogConfiguration.Builder()
                .t()
                .b()
                .st(2)
                .logLevel(LogLevel.ALL)
                .tag("SERVER")
                .build();

        XLog.init(configuration);
    }
}
