package com.zuo.statemachine;

import android.os.Message;
import android.util.Log;

import com.zuo.statemachine.util.State;
import com.zuo.statemachine.util.StateMachine;

public class MyStateMachine extends StateMachine {
    public MyStateMachine(String name) {
        super(name);
        setDbg(true);
    }
}
