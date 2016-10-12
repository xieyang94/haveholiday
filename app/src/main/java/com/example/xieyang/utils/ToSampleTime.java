package com.example.xieyang.utils;

/**
 * Created by Administrator on 2016/8/2.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 从系统获取的时间带有毫秒，前台显示的时候不需要那么精确的时间，需要去掉毫秒
 */
public class ToSampleTime {
    public static String killMsec(String timeStr){

        SimpleDateFormat dateformatAll = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date result = null;

        try {
            result = dateformatAll.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateformatAll.format(result);
    }
}
