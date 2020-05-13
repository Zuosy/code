package com.zuo.statemachine;

import android.content.Context;
import android.os.Message;

import com.elvishew.xlog.XLog;
import com.zuo.statemachine.state.StateGoHome;
import com.zuo.statemachine.state.StateIDLE;
import com.zuo.statemachine.state.StateRecord;
import com.zuo.statemachine.state.StateSearchPOI;
import com.zuo.statemachine.util.StateMachine;

public class MyStateMachine extends StateMachine {

    public static final int CMD_GO_HOME = 11;
    public static final int CMD_SEARCH_POI = 12;

    public static final int HOME_ADDR_REGISTER = 1;
    public static final int HOME_ADDR_UNREGISTER = 2;

//    public static final int PLAY_TTS = 21;
    public static final int SEMANTIC_SEARCH_POI = 21;


    public  StateGoHome goHome = new StateGoHome(this);
    public StateIDLE idle = new StateIDLE(this);
//    public StateStart start = new StateStart(this);
    public StateSearchPOI searchPOI = new StateSearchPOI(this);
    public StateRecord record = new StateRecord(this);


    private Context context;
    private String ttsText;

    public MyStateMachine(String name, Context context) {
        super(name);
        this.context = context;
        init();
    }

    public Context getContext() {
        return context;
    }

    private void init() {
        addState(idle);
        addState(goHome, idle);
        addState(record, idle);
        addState(searchPOI, idle);
        setInitialState(idle);
    }

    @Override
    protected void onPreHandleMessage(Message msg) {
        super.onPreHandleMessage(msg);
        XLog.i("状态机 发送消息前");
        XLog.i("==================");
    }

    @Override
    protected void onPostHandleMessage(Message msg) {
        super.onPostHandleMessage(msg);
        XLog.i("状态机 发送消息后");
        XLog.i("==================");
    }

    @Override
    protected void unhandledMessage(Message msg) {
        super.unhandledMessage(msg);
    }

    public String getTTS() {
        return ttsText;
    }

    public void setTTS(int id) {
        ttsText = context.getString(id); // R.string.app_name
    }

}
