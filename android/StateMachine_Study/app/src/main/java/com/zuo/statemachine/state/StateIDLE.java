package com.zuo.statemachine.state;

import android.os.Message;

import com.elvishew.xlog.XLog;
import com.zuo.statemachine.MyStateMachine;
import com.zuo.statemachine.util.State;

import static com.zuo.statemachine.MyStateMachine.CMD_GO_HOME;
import static com.zuo.statemachine.MyStateMachine.CMD_SEARCH_POI;

public class StateIDLE extends State {

    private MyStateMachine mStateMachine = null;

    public static final int CMD_INIT = 0;

    public static final int CMD_QUIT = 1;
    public static final int CMD_XXXX = 2;

    /**
     * Constructor
     */
    public StateIDLE(MyStateMachine stateMachine) {
        super();
        XLog.i("new StateIDLE");
        mStateMachine = stateMachine;
    }

    @Override
    public void enter() {
        super.enter();
        XLog.i("enter StateIDLE");
    }

    @Override
    public void exit() {
        super.exit();
        XLog.i("exit StateIDLE");
    }

    @Override
    public boolean processMessage(Message msg) {
        XLog.i("processMessage StateIDLE");

        switch (msg.what) {
            case CMD_SEARCH_POI:
                XLog.i("处理SearchPOI");
                mStateMachine.transitionTo(mStateMachine.searchPOI);
                break;
            case CMD_GO_HOME:
                XLog.i("处理GoHome 消息");
                mStateMachine.transitionTo(mStateMachine.goHome);
                break;
            default:
                break;
        }
        return HANDLED;
    }
}
