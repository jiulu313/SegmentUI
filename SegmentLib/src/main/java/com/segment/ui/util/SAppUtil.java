package com.segment.ui.util;


import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by zhanghongjun on 2018/2/2.
 * 必须先初始化 SAppUtil.sContext = context;
 */

public class SAppUtil {
    private static int lastClassGuid = 1;
    public static Point displaySize = new Point();
    public static int statusBarHeight;
    private static Field mAttachInfoField;
    private static Field mStableInsetsField;

    public static Context sContext;

    public static int getDensity(Context context){
        return (int) context.getResources().getDisplayMetrics().density;
    }

    public static int dp(float value) {
        if (value == 0) {
            return 0;
        }
        return (int) Math.ceil(getDensity(sContext) * value);
    }

    public static int dp2(float value) {
        if (value == 0) {
            return 0;
        }
        return (int) Math.floor(getDensity(sContext) * value);
    }

    public static int generateClassGuid(){
        return lastClassGuid++;
    }

    public static int getViewInset(View view) {
        if (view == null || Build.VERSION.SDK_INT < 21 || view.getHeight() == SAppUtil.displaySize.y || view.getHeight() == SAppUtil.displaySize.y - statusBarHeight) {
            return 0;
        }
        try {
            if (mAttachInfoField == null) {
                mAttachInfoField = View.class.getDeclaredField("mAttachInfo");
                mAttachInfoField.setAccessible(true);
            }
            Object mAttachInfo = mAttachInfoField.get(view);
            if (mAttachInfo != null) {
                if (mStableInsetsField == null) {
                    mStableInsetsField = mAttachInfo.getClass().getDeclaredField("mStableInsets");
                    mStableInsetsField.setAccessible(true);
                }
                Rect insets = (Rect) mStableInsetsField.get(mAttachInfo);
                return insets.bottom;
            }
        } catch (Exception e) {
        }
        return 0;
    }


}
