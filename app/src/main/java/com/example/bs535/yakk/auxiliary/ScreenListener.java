package com.example.bs535.yakk.auxiliary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;

/**
 * Created by baolei on 2017/10/3.
 *
 *   1、广播接收器 新建类继承 BroadcastReceiver
 *          onReceive 里面写当接收到广播后执行的方法
 *   2、开启 registerReceiver(新建类，IntentFilter)；  关闭   unregisterReceiver(新建类)
 *          IntentFilter 用addAction添加广播值
 *   3、
 */

public class ScreenListener {
    private Context context;
    private ScreenBroadcastReceiver screenReceiver;//广播
    private ScreenStateListener creenStateListener;//接口

    public ScreenListener(Context context) {
        this.context = context;
        screenReceiver = new ScreenBroadcastReceiver();
    }

    // 开始监听screen状态
    public void begin(ScreenStateListener creenStateListener) {
        this.creenStateListener = creenStateListener;
        registerListener();
        getScreenState();
    }


    // 停止screen状态监听
    public void unregisterListener() {
        context.unregisterReceiver(screenReceiver);
    }

    // 启动screen状态广播接收器
    private void registerListener() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        context.registerReceiver(screenReceiver, filter);
    }

    // 获取screen状态
    private void getScreenState() {
        PowerManager manager = (PowerManager) context
                .getSystemService(Context.POWER_SERVICE);
        if (manager.isScreenOn()) {
            if (creenStateListener != null) {
                creenStateListener.onScreenOn();
            }
        } else {
            if (creenStateListener != null) {
                creenStateListener.onScreenOff();
            }
        }
    }

    // screen状态广播接收者
    private class ScreenBroadcastReceiver extends BroadcastReceiver {
        private String action = null;

        @Override
        public void onReceive(Context context, Intent intent) {
            action = intent.getAction();
            if (Intent.ACTION_SCREEN_ON.equals(action)) { // 开屏
                creenStateListener.onScreenOn();
            } else if (Intent.ACTION_SCREEN_OFF.equals(action)) { // 锁屏
                creenStateListener.onScreenOff();
            } else if (Intent.ACTION_USER_PRESENT.equals(action)) { // 解锁
                creenStateListener.onUserPresent();
            }
        }
    }

    // 返回给调用者屏幕状态信息
    public interface ScreenStateListener {
        public void onScreenOn();

        public void onScreenOff();

        public void onUserPresent();
    }
}