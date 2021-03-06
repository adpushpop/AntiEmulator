package com.example.chenqihong.antiemulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chenqihong.antiemulator.controller.EmulatorPattern;
import com.example.chenqihong.antiemulator.controller.GeneralDetector;

public class MainActivity extends AppCompatActivity {

    GeneralDetector mDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView)findViewById(R.id.main_text);
        mDetector = new GeneralDetector(this);
        mDetector.setEmulatorCheckedListener(new GeneralDetector.EmulatorCheckedListener() {
            @Override
            public void onChecked(boolean[] status) {
                StringBuilder sb = new StringBuilder();
                sb.append("模块状态:（true：符合模拟器特征值/false：不符合） \n电池：" +
                        status[0] + ", \nCPU："+ status[1] + ", \n文件："+
                        status[2] + ", \n网络："+ status[3] + ", \n通讯录："+ status[4] + ", \n传感器:"+
                        status[5] + ", \n存储："+ status[6] + "\n温度：" + status[7] + "\n\n");

                sb.append("模拟器判断：（true：模拟器/false：不是模拟器） ：" +
                        EmulatorPattern.recognize(status));

                textView.setText(sb.toString());
            }
        });

        mDetector.startChecking();

        //textView.setText(Device.printDeviceInf(this));
    }
}
