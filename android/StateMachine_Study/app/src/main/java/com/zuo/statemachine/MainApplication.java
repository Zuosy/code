package com.zuo.statemachine;

import android.app.Application;

import com.autonavi.amapauto.jsonsdk.JsonProtocolManager;
import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;
import com.tencent.wecarspeech.clientsdk.impl.SpeechClientMgr;
import com.tencent.wecarspeech.clientsdk.interfaces.ISpeechClient;
import com.tencent.wecarspeech.clientsdk.interfaces.OnClientReadyCallback;

public class MainApplication extends Application {

    private ISpeechClient speechClient = null;

    public static String mAppId = "d04e133e995914fe0623f87442a354b75b336948";

    @Override
    public void onCreate() {
        super.onCreate();
        initLog();
//        initClientSDK();
    }

    private void initLog() {
        LogConfiguration configuration = new LogConfiguration.Builder()
                .tag("SDS").build();
        XLog.init(LogLevel.ALL, configuration);
        XLog.d("XLog begin");
    }

    private void initClientSDK() {

        speechClient = SpeechClientMgr.getInstance().registerClient(this, mAppId, "");

        SpeechClientMgr.getInstance().init(this, new OnClientReadyCallback() {
            @Override
            public void onClientReady() {
                XLog.i("onClientReady");
            }

            @Override
            public void onInitFailed(int i, String s) {
                XLog.e("onInitFailed error code [%d]%n message[%s]", i, s);
            }

            @Override
            public void onClientDisconnect() {
                XLog.e("onClientDisconnect");
            }
        });
    }

}