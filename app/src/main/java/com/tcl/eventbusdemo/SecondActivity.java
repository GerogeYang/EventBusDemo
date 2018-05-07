package com.tcl.eventbusdemo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tcl.eventbusdemo.event.FirstEvent;
import com.tcl.eventbusdemo.event.SecondEvent;
import com.tcl.eventbusdemo.event.ThirdEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * 项目名：   EventBusDemo
 * 包名：     com.tcl.eventbusdemo
 * 文件名：   SecondActivity
 * 创建者：   70889
 * 创建时间： 2018/5/7 21:21
 * 描述：     TODO
 */

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = SecondActivity.class.getName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Button btnFirstEvent = findViewById(R.id.send_first_event);
        btnFirstEvent.setOnClickListener(this);
        Button btnSecondEvent = findViewById(R.id.send_second_event);
        btnSecondEvent.setOnClickListener(this);
        Button btnThirdEvent = findViewById(R.id.send_third_event);
        btnThirdEvent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_first_event:
                EventBus.getDefault().post(new FirstEvent("fist message"));
                Toast.makeText(this,"发送第一条信息",Toast.LENGTH_SHORT).show();
                break;
            case R.id.send_second_event:
                EventBus.getDefault().post(new SecondEvent("second message"));
                Toast.makeText(this,"发送第二条信息",Toast.LENGTH_SHORT).show();
                break;
            case R.id.send_third_event:
                EventBus.getDefault().post(new ThirdEvent("third message"));
                Toast.makeText(this,"发送第三条信息",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
