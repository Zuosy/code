package com.zuo.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.zuo.msg.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.View;

import com.elvishew.xlog.XLog;
import com.zuo.server.MessageCallBack;
import com.zuo.server.SendMessageInterface;

public class MainActivity extends AppCompatActivity {

    private MessageCallBack callBack = new MessageCallBack.Stub() {
        @Override
        public void callBack(String msg) throws RemoteException {
            XLog.d("callback [%s]", msg);
        }
    };


    private SendMessageInterface sendMessageInterface = null;


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            XLog.d("onServiceConnected");
            sendMessageInterface = SendMessageInterface.Stub.asInterface(service);
            try {
                sendMessageInterface.registerCallBack(callBack);
            } catch (Exception ex) {

            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            XLog.d("onServiceDisconnected");
            sendMessageInterface = null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBind(View view) {
        XLog.d("bindService");
        Intent intent = new Intent("安卓AIDL学习");
        intent.setPackage("com.zuo.server");
        bindService(intent, this.connection, Context.BIND_AUTO_CREATE);
    }

    public void onUnBind(View view) {
        XLog.d("unBindService");
        try {
            if (sendMessageInterface != null) {
                sendMessageInterface.unregisterCallBack();
            }
        } catch (Exception ex) {

        }
        unbindService(this.connection);
    }

    public void onSend(View view) {
        XLog.d("发送消息了啊");
        if (sendMessageInterface == null) {
            XLog.e("interface is null");
        }
        try {
            sendMessageInterface.sendMessage("我和我的祖国，一刻都不能分割");


            Message msg = new Message();
            msg.setPoiName("麦当劳");
            msg.setLocation("东方明珠");
            msg.setPhoneNumber("010-1234567");
            msg.setDistance(14);
            sendMessageInterface.sendMsg(msg);
        } catch (Exception ex) {

        }
    }

}
