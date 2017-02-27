package com.example.xieyang.aty;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.demo3.R;
import com.example.xieyang.base.BaseActivity;
import com.example.xieyang.presenter.SumHoliday_month_Presenter;
import com.example.xieyang.utils.GetHolidayName;
import com.example.xieyang.utils.Lunar;
import com.example.xieyang.utils._24SolarTerms;
import com.example.xieyang.view.SumHoliday_month_View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

public class SumHoliday_month_Activity extends BaseActivity<SumHoliday_month_View, SumHoliday_month_Presenter> implements SumHoliday_month_View,View.OnClickListener {
    private ListView holiday_month_list;
    private ImageView title_back;
    private ArrayAdapter<String> adapter;        //定义一个适配器
    public GetHolidayName getHolidayName;
    public _24SolarTerms solarTerms;
    public Lunar lunar;
    private String str1;
    private int now_month, now_year;
    private String lunarmonth,holiday_name;
    private String[] every_lunarday = {"初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九",
            "初十", "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "廿十",
            "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "卅十"};

    public void init() {
        holiday_month_list = (ListView) findViewById(R.id.holiday_month_name_list);         //寻址
        title_back= (ImageView) findViewById(R.id.title_back);
        title_back.setOnClickListener(this);
    }

    List<String> holiday_month_arr = new ArrayList<String>();    //定义一个适配器列表


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_holiday_month_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        str1 = getIntent().getStringExtra("now_month");
        now_month = Integer.parseInt(str1);
        getHolidayofMonth(now_month);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, holiday_month_arr);  //获取适配器类型
        holiday_month_list.setAdapter(adapter); //呈现

        holiday_month_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SumHoliday_month_Activity.this, HolidayContent_Avtivity.class);
                intent.putExtra("holiday", "" + holiday_month_arr.get(position));
                startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public SumHoliday_month_Presenter createPresenter() {
        return new SumHoliday_month_Presenter();
    }

    /*
    *1.阳历节日，比较好获取<传入当前月份，每月取最大值31天就可以getHoliday(int month, int day)>
    *2.阴历节日
    *3.24节气
    *4.每月的第几周的周几
    *5.除夕
     */
    //当前年份
    Calendar instance = Calendar.getInstance();
    int Years=instance.get(Calendar.YEAR);

    public void getHolidayofMonth(int month) {
        //阳历的节日
        for (int i = 1, j = month; i <= 31; i++) {
            if (getHolidayName.getHoliday(Years,j, i).equals("")) {
            } else {
                StringTokenizer st = new StringTokenizer(getHolidayName.getHoliday(Years,j, i), ",");
                while (st.hasMoreTokens()) {
                    holiday_month_arr.add(st.nextToken() + "      " + month + "月" + i + "日");
                }
            }

            //24节气  ——> solarTermToString(int year,int month,int day)
            Calendar c = Calendar.getInstance();
            now_year = c.get(Calendar.YEAR);
            String str = solarTerms.solarTermToString(now_year, month, i);
            if (str == "") {
            } else {
                holiday_month_arr.add(str + "      " + month + "月" + i + "日");
            }

        }

        //阴历中的节日
        /**
         * 显示形式：当前月份即表示阳历月份也表示阴历月份，双重结合
         * 1.阿拉伯数字和汉字的不同显示表示阳历和阴历
         * 2.不会突兀显示节日，阴阳不调；例如：在阳历6月份，出现阴历五月份的端午节
         * 3.智商高的人看得懂
         */
        lunarmonth=change(month);
        for (String str:every_lunarday){
            holiday_name=getHolidayName.getLunarHoliday(lunarmonth,str,"","");
            if(holiday_name==""){}
            else{
                StringTokenizer st1 = new StringTokenizer(holiday_name, ",");
                while (st1.hasMoreTokens()) {
                    String lunarstr = st1.nextToken();
                    holiday_month_arr.add(lunarstr+ "        " +lunarmonth+"月"+str);
                }
            }
        }
        // 确定除夕
        int dayofchuxi = Lunar.monthDays(now_year,month);
        String str1 = "";
        if (dayofchuxi == 29) {
            str1 = "廿九";
        } else if (dayofchuxi == 30) {
            str1 = "卅十";
        }

        if (lunarmonth=="十二"){
            holiday_month_arr.add("除夕"+ "        " +lunarmonth+"月"+str1);
        }

    }

    public String  change(int count){
        if(count==1)    return "一";
        if(count==2)    return "二";
        if(count==3)    return "三";
        if(count==4)    return "四";
        if(count==5)    return "五";
        if(count==6)    return "六";
        if(count==7)    return "七";
        if(count==8)    return "八";
        if(count==9)    return "九";
        if(count==10)    return "十";
        if(count==11)    return "十一";
        if(count==12)    return "十二";
        return "";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }
}
