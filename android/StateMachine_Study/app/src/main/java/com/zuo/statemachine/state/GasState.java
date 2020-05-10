package com.zuo.statemachine.state;

import android.os.Message;

import com.elvishew.xlog.XLog;
import com.zuo.statemachine.util.State;

public class GasState extends State {
    /**
     * Constructor
     */
    public GasState() {
        super();
    }

    @Override
    public void enter() {
        super.enter();
        XLog.d("变成了气体");
    }

    @Override
    public void exit() {
        super.exit();
        XLog.d("退出气体状态");
    }

    @Override
    public boolean processMessage(Message msg) {
        XLog.d("当前状态为气体");
        return super.processMessage(msg);
    }
}
