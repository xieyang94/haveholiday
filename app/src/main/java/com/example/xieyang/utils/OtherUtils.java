package com.example.xieyang.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Administrator on 2016/8/24.
 */
public class OtherUtils {
    //键盘隐藏,显示时隐藏，隐藏时显示
    public static void hideL(Context context){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
