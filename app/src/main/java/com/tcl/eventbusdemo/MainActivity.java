package com.tcl.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tcl.eventbusdemo.event.FirstEvent;
import com.tcl.eventbusdemo.event.SecondEvent;
import com.tcl.eventbusdemo.event.ThirdEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.startSecond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                startActivity(intent);
            }
        });
        info = findViewById(R.id.textview);
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onEventMainThread(FirstEvent event) {
        String msg = event.getMsg();
        info.setText(msg);
        Log.d(TAG, "onEventMainThread收到了消息：" + msg);

    }

    @Subscribe
    public void onEventMainThread(SecondEvent event) {
        String msg = event.getMsg();
        info.setText(msg);
        Log.d(TAG, "onEventMainThread收到了消息：" + msg);
    }

    @Subscribe
    public void onEvent(ThirdEvent event) {
        String msg = event.getMsg();
        info.setText(msg);
        Log.d(TAG, "onEvent收到了消息：" + msg);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
