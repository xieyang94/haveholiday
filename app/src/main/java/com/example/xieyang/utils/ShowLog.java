package com.example.xieyang.utils;

import android.util.Log;

/**
 * Created by xieyang on 2017/2/27.
 */

public class ShowLog {
    /**
     * 打印Log
     *
     * @param TAG     标签
     * @param content 内容
     */
    public static void showTag(String TAG, String content) {
        Log.d("" + TAG, "" + content);
    }

    /**
     * 打印Log
     *
     * @param content 内容，标签为TAG
     */
    public static void showTag(String content) {
        showTag("TAG", "" + content);
    }
}
