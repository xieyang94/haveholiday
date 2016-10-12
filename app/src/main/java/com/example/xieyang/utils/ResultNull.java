package com.example.xieyang.utils;

/**
 * Created by Administrator on 2016/8/1.
 */
public class ResultNull {
    public static String solveNull(String str){

        str=(str == null || str == "null"|| str.isEmpty()) ?"": str;
        return str;
    }
}
