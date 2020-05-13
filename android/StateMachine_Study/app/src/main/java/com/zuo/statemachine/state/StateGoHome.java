package com.zuo.statemachine.state;

import android.os.Message;

import com.elvishew.xlog.XLog;
import com.tencent.wecarspeech.clientsdk.impl.SpeechClientMgr;
import com.tencent.wecarspeech.clientsdk.interfaces.ISpeechClient;
import com.zuo.statemachine.MainActivity;
import com.zuo.statemachine.MainApplication;
import com.zuo.statemachine.MyStateMachine;
import com.zuo.statemachine.R;
import com.zuo.statemachine.util.State;

import static com.zuo.statemachine.MyStateMachine.HOME_ADDR_REGISTER;
import static com.zuo.statemachine.MyStateMachine.HOME_ADDR_UNREGISTER;

public class StateGoHome extends State {

    private MyStateMachine mStateMachine = null;

    /**
     * Constructor
     */
    public StateGoHome(MyStateMachine stateMachine) {
        super();
        XLog.i("new StateGoHome");
        mStateMachine = stateMachine;
    }

    @Override
    public void enter() {
        super.enter();
        XLog.i(">>>>> StateGoHome");
        XLog.i("向高德发送导航回家的请求");
        MainActivity.goHome();
    }

    @Override
    public void exit() {
        super.exit();
        XLog.i("exit StateGoHome");
    }

    @Override
    public boolean processMessage(Message msg) {
        XLog.i("processMessage StateGoHome");
        switch (msg.what) {
            case HOME_ADDR_REGISTER:
                XLog.i("正在为您规划路线");
                return true;
            case HOME_ADDR_UNREGISTER:
                // 从这里退出，GoHome状态
                XLog.i("StateGoHome 处理HOME_ADDR_UNREGISTER");
                mStateMachine.transitionTo(mStateMachine.record);
                mStateMachine.setTTS(R.string.sayHomeAddress);
                return true;
            default:
                break;
        }
        return false;
    }


}
