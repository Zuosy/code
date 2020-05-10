package com.zuo.statemachine.state;

import android.os.Message;

import com.elvishew.xlog.XLog;
import com.zuo.statemachine.MainActivity;
import com.zuo.statemachine.util.State;

import static com.zuo.statemachine.MainActivity.CMD_COLDER;
import static com.zuo.statemachine.MainActivity.CMD_HOTTER;

public class LiquidState extends State {
    /**
     * Constructor
     */
    public LiquidState() {
        super();
    }

    @Override
    public void enter() {
        super.enter();
        XLog.d("变成了液体");
        // 进入该状态时的准备工作
    }

    @Override
    public void exit() {
        super.exit();
        XLog.d("退出液体状态");
        // 退出该状态的善后工作
    }

    @Override
    public boolean processMessage(Message msg) {
        // 处于该状态时做出相应的处理
        XLog.d("当前为液体");

        switch (msg.what) {
            case CMD_HOTTER:
                // 变成气体
                XLog.d("液体加热了");
//                MainActivity.stateMachine.transitionTo(MainActivity.gasState);

                break;
            case CMD_COLDER:
                // 变成固体
                break;
            default:
                return false;
        }
        return true;
    }
}
