package com.zuo.server;

import com.zuo.server.MessageCallBack;
import com.zuo.msg.Message;

interface SendMessageInterface {

    void registerCallBack(MessageCallBack callback);

    void unregisterCallBack();

    void sendMessage(String message);
    void sendMsg(in Message msg);
}
