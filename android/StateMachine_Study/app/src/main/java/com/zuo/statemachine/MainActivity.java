package com.zuo.statemachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.autonavi.amapauto.jsonsdk.IJsonProtocolReceive;
import com.autonavi.amapauto.jsonsdk.JsonProtocolManager;
import com.elvishew.xlog.XLog;
import com.google.gson.Gson;
import com.zuo.statemachine.json.Data;
import com.zuo.statemachine.json.RequestJson;
import com.zuo.statemachine.util.IState;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements IJsonProtocolReceive {

    public static MyStateMachine stateMachine;

    private JsonProtocolManager jsonProtocolManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        XLog.d("============    ACTIVITY ON CREATE    =============");
        initSM();
        initAMap();
    }

    private void initSM() {
        stateMachine = new MyStateMachine("SAS", getApplicationContext());
        stateMachine.setDbg(true);
        stateMachine.start();
    }

    private void initAMap() {
        jsonProtocolManager = JsonProtocolManager.getInstance();
        jsonProtocolManager.init(getApplicationContext());
        jsonProtocolManager.setJsonProtocolReceive(this);
    }

    public static void goHome() {
        Gson gson = new Gson();
        String json = gson.toJson(new RequestJson<Data>());
        XLog.i("导航回家请就Json %n[%s]", json);
        JsonProtocolManager.getInstance().request(json);
    }

    public static void searchPoiList() {
        XLog.i("向高的请求，SearchPoi List");
        String json = "{\n" +
                "\t\"requestCode\": \"123456789\",\n" +
                "\t\"responseCode\": \"\",\n" +
                "\t\"needResponse\": true,\n" +
                "\t\"protocolId\": 30300,\n" +
                "\t\"versionName\": \"v_20180327\",\n" +
                "\t\"requestAuthor\": \"xunfei\",\n" +
                "\t\"message\": \"\",\n" +
                "\t\"messageType\": \"request\",\n" +
                "\t\"statusCode\": 0,\n" +
                "\t\"data\": {\n" +
                "\t\t\"searchType \": 0,\n" +
                "\t\t\"keywords\": \"中国上海市浦东新区陆家嘴金融贸易区世纪大道1号\",\n" +
                "\t\t\"mylocLon\": 118.101011,\n" +
                "\t\t\"mylocLat\": 24.444593,\n" +
                "\t\t\"maxCount\": 5,\n" +
                "\t\t\"dev\": 0,\n" +
                "\t\t\"city\": \"上海市\"\n" +
                "\t}\n" +
                "}";
        JsonProtocolManager.getInstance().request(json);
    }

    public void onClickGoHome(View view) {
        XLog.i("导航回家的语义下发");
        stateMachine.sendMessage(MyStateMachine.CMD_GO_HOME);
        Message msg = stateMachine.obtainMessage();
        msg.obj = "poi key word";
        stateMachine.sendMessage(msg);
        stateMachine.obtainMessage();
//        stateMachine.obtainMessage()
    }

    public void onClickGetState(View view) {
        IState state = stateMachine.getCurrentState();
        XLog.i("当前状态为 [%s]", state.getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        XLog.d("============    ACTIVITY ON DESTORY    =============");
        jsonProtocolManager.destroy();
    }

    public void onClickMockDingDangCallBack(View view) {
        XLog.i("DingDang下发语义");
        XLog.i("解析语义");
        stateMachine.sendMessage(MyStateMachine.SEMANTIC_SEARCH_POI);
        stateMachine.getCurrentState();
    }


    // ========================== IJsonProtocolReceive ==========================

    @Override
    public void received(String string) {
//        XLog.i("从高的来的回调 [%s]", string);
        try {
            JSONObject jsonObject = new JSONObject(string);
            int protocolId = jsonObject.optInt("protocolId", -1);
            if (protocolId == 30400) {
                XLog.i("高德回调导航回家的结果, 假设家庭地址未注册");
                stateMachine.sendMessage(MyStateMachine.HOME_ADDR_UNREGISTER);
            } else if (protocolId == 30300){
                XLog.i("高德回调 POI LIST[%s]", string);
                stateMachine.setTTS(R.string.selectPoi);
                stateMachine.sendMessage(MyStateMachine.CMD_SEARCH_POI, new Object());
            }
        } catch (Exception ex) {

        }

    }

    @Override
    public String receivedSync(String string) {
        XLog.i("好像是同步的回调 [%s]", string);
        return null;
    }
}