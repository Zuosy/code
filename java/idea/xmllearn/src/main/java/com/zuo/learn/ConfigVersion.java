package com.zuo.learn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

/**
 * @ClassName GsonBuilder.setVersion使用方法介绍
 * @Description TODO
 * @Author Zuosy
 * @Date 2020/6/8
 */
public class ConfigVersion {
    class Student {
        @Since(1.1) String name;
        @Since(1.1) @Until(9.0) int age;
        @Since(6.2) String school;
    }

    private GsonBuilder gsonBuilder = null;

    public ConfigVersion(double version) {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.setVersion(version); // 设置版本号,序列化和反序列话的时候自动屏蔽不支持的版本
        // 需要配合注解 @Since 和 @Until
    }

    public void run() {
        System.out.println("serialization test");
        serializationTest();

    }

    public void serializationTest() {
        Gson gson = gsonBuilder.create();
        Student stu = new Student();
        stu.name = "XiaMingXue";
        stu.age = 20;
        stu.school = "HNU";
        System.out.println(gson.toJson(stu));
    }

}

