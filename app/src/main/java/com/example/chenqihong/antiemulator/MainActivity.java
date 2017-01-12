package com.example.chenqihong.antiemulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String deviceInfo = Device.printDeviceInf("DeviceInfo", this);
        TextView textView = (TextView)findViewById(R.id.main_text);
        textView.setText(deviceInfo);
    }
}