package com.zuo.statemachine.check;

public interface CheckNetWork {
    default void print() {
        System.out.println("当前网络状态");
    }

    static void output() {
        System.out.println("PIN PIN PIN");
    }
}
