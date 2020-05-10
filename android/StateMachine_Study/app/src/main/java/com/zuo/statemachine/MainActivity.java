package com.zuo.statemachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.elvishew.xlog.XLog;
import com.zuo.statemachine.state.GasState;
import com.zuo.statemachine.state.LiquidState;
import com.zuo.statemachine.state.SolidState;

public class MainActivity extends AppCompatActivity {

    public static MyStateMachine stateMachine;
    public static final int CMD_COLDER = 1;
    public static final int CMD_HOTTER = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        XLog.d("============    ACTIVITY ON CREATE    =============");
        init();
    }

    public static LiquidState liquidState = new LiquidState();
    public static GasState gasState = new GasState();
    public static SolidState solidState = new SolidState();

    private void init() {
        stateMachine = new MyStateMachine("PACKAGE NAME");
        stateMachine.addState(liquidState, null);
        stateMachine.addState(gasState, liquidState);
        stateMachine.addState(solidState, liquidState);
        stateMachine.setInitialState(liquidState);
        stateMachine.start();
//        stateMachine.start(); // 如果状态机已经开始了,再次调用会独立root状态.
    }

    public void onClickHotter(View view) {
        stateMachine.sendMessage(CMD_HOTTER);
    }

    public void onClickColder(View view) {
        stateMachine.sendMessage(CMD_COLDER);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        XLog.d("============    ACTIVITY ON DESTORY    =============");
    }
}
