package com.zuo.client;

import android.app.Application;

import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogConfiguration configuration =
                new LogConfiguration.Builder().logLevel(LogLevel.ALL)
                    .t()
                    .b()
                    .tag("CLIENT")
                    .st(2)
                    .build();
        XLog.init(configuration);
    }
}
