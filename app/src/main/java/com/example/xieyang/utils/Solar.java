package com.example.xieyang.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2016/7/24.
 */
public class Solar {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    //判断平年闰年
    private static int isleapyear(int year) {
        int is;

        is=((year%4==0&&year%100!=0)||year%400==0)?1:0;
        return is;
    }
    //判断某年某月的天数
    public static int setDayCount(int year,int month){
        int day=0;

        if (month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
            day=31;
        }
        else if(month==4||month==6||month==9||month==11){
            day=30;
        }
        else{
            if (isleapyear(year)==0) {
                day=28;
            }else{
                day=29;
            }
        }

        return day;
    }


    //获取当前的日期
    public static String Date() {
        Date dt=new Date();
        SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
        String str=matter1.format(dt);
        return str;
    }
    //字符串切割为数组
    public static String[] StrToArray(String str,String str1){
        String[] aa = str.split(str1);
        return aa;
    }

    //获取当前的年份
    public static String nowYear(){
        String date1=Date();

        //String[] date2=date1.split("-");
        String[] date2=StrToArray(date1, "-");
        return date2[0];

    }
    //获取当前的月份
    public static String nowMonth(){
        String date1=Date();

        String[] date2=StrToArray(date1, "-");
        return date2[1];

    }
    //获取当前天
    public static String nowDay(){
        String date1=Date();

        String[] date2=StrToArray(date1, "-");
        return date2[2];

    }


    //字符串转化为数字
    public static int StrToInt(String str){
        int i=Integer.parseInt(str);
        return i;
    }



    //获取当月的第一天是周几
    public static int dayOfWeek(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        //calendar.get(Calendar.DAY_OF_WEEK);
        SimpleDateFormat format = new SimpleDateFormat("E");
        String str=format.format(calendar.getTime());
        int dayOfWeek=0;
        switch (str) {
            case "sun":
                dayOfWeek=7;
                break;

            case "mon":
                dayOfWeek=1;
                break;
            case "tue":
                dayOfWeek=2;
                break;

            case "wed":
                dayOfWeek=3;
                break;
            case "thu":
                dayOfWeek=4;
                break;

            case "fri":
                dayOfWeek=5;
                break;
            case "sat":
                dayOfWeek=6;
                break;

        }
        return dayOfWeek;

    }

    //某年某月的第一天是周几
    public static int getWeek(int year,int month)
    {
        Calendar now = Calendar.getInstance();
        now.set(year,month-1,1);
        int week = now.get(Calendar.DAY_OF_WEEK);
        return week ;
    }

}
