package com.segment.ui.core;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by zhanghongjun on 2018/2/6.
 */

public class SegmentApplication extends Application{
    public static volatile Context applicationContext;
    public static volatile Handler applicationHandler;
    private static volatile boolean applicationInited = false;

    public static volatile boolean isScreenOn = false;
    public static volatile boolean mainInterfacePaused = true;
    public static volatile boolean mainInterfacePausedStageQueue = true;
    public static volatile long mainInterfacePausedStageQueueTime;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationContext = getApplicationContext();
        applicationHandler = new Handler(getMainLooper());
    }
}
