package com.zuo.statemachine.state;

import android.os.Message;

import com.elvishew.xlog.XLog;
import com.zuo.statemachine.MainActivity;
import com.zuo.statemachine.MyStateMachine;
import com.zuo.statemachine.util.State;

import static com.zuo.statemachine.MyStateMachine.SEMANTIC_SEARCH_POI;

public class StateRecord extends State {

    private MyStateMachine stateMachine;

    /**
     * Constructor
     */
    public StateRecord(MyStateMachine stateMachine) {
        super();
        this.stateMachine = stateMachine;
    }

    @Override
    public void enter() {
        super.enter();
        XLog.i(">>>>> 录音");
        if (stateMachine.getTTS() != null ||
           !stateMachine.getTTS().isEmpty()) {
            XLog.i("播报TTS [%s]", stateMachine.getTTS());
        }
    }

    @Override
    public void exit() {
        super.exit();
        XLog.i("<<<<< 录音");
    }

    @Override
    public boolean processMessage(Message msg) {
        switch (msg.what) {
            case SEMANTIC_SEARCH_POI:
                MainActivity.searchPoiList();
                return true;
            default:
                break;
        }
        return false;
    }
}
