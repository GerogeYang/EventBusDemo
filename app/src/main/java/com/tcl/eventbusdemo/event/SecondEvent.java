package com.tcl.eventbusdemo.event;

import android.util.Log;

/**
 * 项目名：   EventBusDemo
 * 包名：     com.tcl.eventbusdemo.event
 * 文件名：   SecondEvent
 * 创建者：   70889
 * 创建时间： 2018/5/7 21:30
 * 描述：     TODO
 */

public class SecondEvent {
    private static final String TAG = SecondEvent.class.getName();
    private String msg;

    public SecondEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        Log.i(TAG, "getMsg: msg = " + msg);
        return msg;
    }
}
