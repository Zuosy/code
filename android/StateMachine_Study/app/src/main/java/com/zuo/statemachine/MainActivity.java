package com.zuo.statemachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity {

    private MyStateMachine stateMachine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stateMachine = new MyStateMachine("package_name");
        Log.d("TOM_CAT", stateMachine.toString());
    }

    public void onClick(View view) {
        stateMachine.t1();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
