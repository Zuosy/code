package com.zuo.statemachine.state;

import android.os.Message;

import com.elvishew.xlog.XLog;
import com.zuo.statemachine.MyStateMachine;
import com.zuo.statemachine.util.State;

public class StateSearchPOI extends State {
    /**
     * Constructor
     */
    public StateSearchPOI(MyStateMachine stateMachine) {
        super();
        mStateMachine = stateMachine;
    }

    private MyStateMachine mStateMachine;

    @Override
    public void enter() {
        super.enter();
        XLog.i(">>>>> StateSearchPOI");
        XLog.i(">>>>> 录音");
        XLog.i("发送PoiList给UI");
        if (mStateMachine.getTTS() != null ||
                !mStateMachine.getTTS().isEmpty()) {
            XLog.i("播报TTS [%s]", mStateMachine.getTTS());
        }
        XLog.i("用户选择的地几个，尚未施工");
    }



    @Override
    public void exit() {
        super.exit();
        XLog.i("<<<<< StateSearchPOI");
    }

    @Override
    public boolean processMessage(Message msg) {
        XLog.i("processMessage StateSearchPOI");
        XLog.i("用户选择的地几个，尚未施工");

        return true;
    }
}
