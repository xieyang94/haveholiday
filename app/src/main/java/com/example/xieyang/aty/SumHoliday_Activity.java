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
import com.example.xieyang.common.BaseActivity;
import com.example.xieyang.presenter.SumHoliday_Presenter;
import com.example.xieyang.utils.GetHolidayName;
import com.example.xieyang.view.SumHoliday_View;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SumHoliday_Activity extends BaseActivity<SumHoliday_View, SumHoliday_Presenter> implements SumHoliday_View ,View.OnClickListener{
    private ListView holiday_name_list;
    private ImageView title_back;
    private ArrayAdapter<String> adapter;        //定义一个适配器
    public GetHolidayName getHolidayName;
    public int count = 0;//记录一个月有多少个节日
    private String str2, str3, str4, str5, str6,str7;
    List<String> arr = new ArrayList<String>();    //定义一个适配器列表

    public void init() {
        holiday_name_list = (ListView) findViewById(R.id.holiday_name_list);
        title_back= (ImageView) findViewById(R.id.title_back);
        title_back.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_holiday);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String str = getIntent().getStringExtra("month");
        String str1 = getIntent().getStringExtra("dayCount");
        str2 = getIntent().getStringExtra("lunarmonth");
        str3 = getIntent().getStringExtra("lunarlastday");
        str4 = getIntent().getStringExtra("solarTerm");
        str5 = getIntent().getStringExtra("lunar_holiday");
        str6 = getIntent().getStringExtra("lunar_chuxi");
        str7 = getIntent().getStringExtra("year");
        init();

        int year=Integer.parseInt(str7);
        //阳历节日
        int dayCount = Integer.parseInt(str1);
        int month = Integer.parseInt(str);
        for (int i = 1, j = month; i <= dayCount; i++) {
            if (getHolidayName.getHoliday(year,j, i).equals("")) {
            } else {
                StringTokenizer st = new StringTokenizer(getHolidayName.getHoliday(year,j, i), ",");
                while (st.hasMoreTokens()) {
                    arr.add(st.nextToken() + "      " + str + "月" + i + "日");
                }
            }

        }

        //24节气
        StringTokenizer st = new StringTokenizer(str4, ",");
        while (st.hasMoreTokens()) {
            arr.add(st.nextToken());
        }
        //阴历节日

        StringTokenizer st1 = new StringTokenizer(str5, ",");
        while (st1.hasMoreTokens()) {
            String solarstr = st1.nextToken();
            String pchuxi = str6;
            //确定除夕
            if (str6.equals(solarstr)) {
                arr.add("除夕" + "        " + solarstr);
            }
            if (getHolidayName.getLunarHoliday("", "", solarstr, "").equals("")) {
            } else {
                StringTokenizer st2 = new StringTokenizer(getHolidayName.getLunarHoliday("", "", solarstr, ""), ",");
                while (st2.hasMoreTokens()) {
                    String strf=st2.nextToken();
                    arr.add(strf + "        " + solarstr);
                }
            }
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);  //获取适配器类型
        holiday_name_list.setAdapter(adapter);                      //呈现

        holiday_name_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(SumHoliday_Activity.this,HolidayContent_Avtivity.class);
                intent.putExtra("holiday",""+arr.get(position));
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }

    @NonNull
    @Override
    public SumHoliday_Presenter createPresenter() {
        return new SumHoliday_Presenter();
    }
}