package com.example.xieyang.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/24.
 */
public class DateUtils {
    /**
     * 起始日期+天数=返回的结果日期
     * 日期格式yyyy-MM-DD
     * @param dateBegin 起始日期
     * @param dayCount 天数
     * @return 结果日期
     */
    public static String upDate(String dateBegin,int dayCount){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// 输入日期的格式
        Date date1 = null;
        try {
            date1 = simpleDateFormat.parse(dateBegin);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        cal.add(Calendar.DATE, dayCount);
        String str=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
        return str;
    }
}
