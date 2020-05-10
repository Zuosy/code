package com.zuo.statemachine;

import android.app.Application;

import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogConfiguration configuration = new LogConfiguration.Builder()
                .tag("PACKAGE NAME").build();
        XLog.init(LogLevel.ALL, configuration);
        XLog.d("XLog begin");
    }
}
