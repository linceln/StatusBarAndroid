package com.xyz.statusbar;

import android.app.Activity;
import android.os.Build;
import android.view.Window;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MIUIUtil {

    /**
     * MIUI6以上
     * 状态栏图标暗色
     */
    public static void setStatusBarIconDark(Activity activity) {
        if (Build.MANUFACTURER.equals("Xiaomi")) {

            Window window = activity.getWindow();
            Class<?> clazz = window.getClass();
            try {
                int tranceFlag = 0;
                int darkModeFlag = 0;
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                if (layoutParams == null) {
                    return;
                }
                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT");
                tranceFlag = field.getInt(layoutParams);

                field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);

                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                //只需要状态栏透明
//            extraFlagField.invoke(window, tranceFlag, tranceFlag);
                //或 状态栏透明且黑色字体
//            extraFlagField.invoke(window, tranceFlag | darkModeFlag, tranceFlag | darkModeFlag);
                extraFlagField.invoke(window, darkModeFlag, darkModeFlag);
                //清除黑色字体
//            extraFlagField.invoke(window, 0, darkModeFlag);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setStatusBarIconLight(Activity activity) {
        if (Build.MANUFACTURER.equals("Xiaomi")) {

            Window window = activity.getWindow();
            Class clazz = window.getClass();
            try {
                int tranceFlag = 0;
                int darkModeFlag = 0;
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");

                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT");
                tranceFlag = field.getInt(layoutParams);

                field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);

                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                //只需要状态栏透明
//            extraFlagField.invoke(window, tranceFlag, tranceFlag);
                //状态栏透明且黑色字体
//            extraFlagField.invoke(window, tranceFlag | darkModeFlag, tranceFlag | darkModeFlag);
                //清除黑色字体
                extraFlagField.invoke(window, 0, darkModeFlag);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
