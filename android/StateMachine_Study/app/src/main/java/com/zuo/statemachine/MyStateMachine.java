package com.zuo.statemachine;

import android.net.wifi.WifiEnterpriseConfig;
import android.os.Message;
import android.util.Log;

public class MyStateMachine extends StateMachine {
    public MyStateMachine(String name) {
        super(name);
        setDbg(true);
        constructStatesHierarchy();
    }

    private State s2;
    private State s3;
    private State p1;
    private State p2;

    private void constructStatesHierarchy() {
        State s1 = new S1();
        s2 = new S2();
        s3 = new S3();
        p1 = new P1();
        addState(s1, p1);
        addState(s2, p1);
        addState(s3, s1);

        p2 = new P2();
        addState(p2);
        setInitialState(s1);
        start();
    }

    public void t1() {
        transitionTo(s2);
    }


    public static class S1 extends State {
        @Override
        public void enter() {
            super.enter();
            Log.d("TOM_CAT", "s1 enter");
        }

        @Override
        public void exit() {
            super.exit();
            Log.d("TOM_CAT", "s1 exit");
        }

        @Override
        public boolean processMessage(Message msg) {
            Log.d("TOM_CAT", "s1 processMessage");
            return super.processMessage(msg);
        }
    }

    public static class S2 extends State {
        @Override
        public void enter() {
            super.enter();
            Log.d("TOM_CAT", "s2 enter");
        }

        @Override
        public void exit() {
            super.exit();
            Log.d("TOM_CAT", "s2 exit");
        }

        @Override
        public boolean processMessage(Message msg) {
            Log.d("TOM_CAT", "s2 processMessage");
            return super.processMessage(msg);
        }
    }

    public static class S3 extends State {

    }

    public static class P1 extends State {
        @Override
        public void enter() {
            super.enter();
            Log.d("TOM_CAT", "p1 enter");
        }

        @Override
        public void exit() {
            super.exit();
            Log.d("TOM_CAT", "p1 exit");
        }

        @Override
        public boolean processMessage(Message msg) {
            Log.d("TOM_CAT", "p1 processMessage");
            return super.processMessage(msg);
        }
    }

    public static class P2 extends State {

    }

}
