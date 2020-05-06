package com.zuo.server.binder;

import android.os.RemoteException;

import com.elvishew.xlog.XLog;
import com.zuo.msg.Message;
import com.zuo.server.MessageCallBack;
import com.zuo.server.SendMessageInterface;

import java.util.ArrayList;
import java.util.List;

public class SendMessage extends SendMessageInterface.Stub {
    MessageCallBack callBack;
    List<MessageCallBack> callBackList = new ArrayList<>();

    @Override
    public void registerCallBack(MessageCallBack callback) throws RemoteException {
        XLog.d("registerCallBack");
        this.callBack = callback;
    }

    @Override
    public void unregisterCallBack() throws RemoteException {
        XLog.d("unregisterCallBack");
        this.callBack = null;
    }

    @Override
    public void sendMessage(String message) throws RemoteException {
        XLog.d("MESSAGE " + message);
        if (callBack == null) {
            XLog.e("callBack is null");
        }
        callBack.callBack("我收到你的消息了");
    }

    @Override
    public void sendMsg(Message msg) throws RemoteException {
        XLog.d("我这里应该是接受Bundle喽");
        XLog.i("location [%s]", msg.getLocation());
        XLog.i("poi name [%s]", msg.getPoiName());
        XLog.i("phone number [%s]", msg.getPhoneNumber());
        XLog.i("distance [%d]", msg.getDistance());
    }
}
