package com.tcl.eventbusdemo.event;

import android.util.Log;

/**
 * 项目名：   EventBusDemo
 * 包名：     com.tcl.eventbusdemo.event
 * 文件名：   FirstEvent
 * 创建者：   70889
 * 创建时间： 2018/5/7 21:29
 * 描述：     TODO
 */

public class FirstEvent {
    private static final String TAG = FirstEvent.class.getName();
    private String msg;

    public FirstEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        Log.i(TAG, "getMsg: msg = " + msg);
        return msg;
    }
}
