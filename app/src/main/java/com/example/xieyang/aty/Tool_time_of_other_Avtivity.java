package com.example.xieyang.aty;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.demo3.R;
import com.example.xieyang.base.BaseActivity;
import com.example.xieyang.presenter.Tool_time_of_other_Presenter;
import com.example.xieyang.view.Tool_time_of_other_View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Tool_time_of_other_Avtivity extends BaseActivity<Tool_time_of_other_View,Tool_time_of_other_Presenter> implements Tool_time_of_other_View,View.OnClickListener{

    private TextView activity_tool_time_of_other_begin,activity_tool_time_of_other_end,activity_tool_time_of_other_sum;
    private ImageView title_back;
    public void init(){
        activity_tool_time_of_other_begin=(TextView)findViewById(R.id.activity_tool_time_of_other_begin);
        activity_tool_time_of_other_end=(TextView)findViewById(R.id.activity_tool_time_of_other_end);
        activity_tool_time_of_other_sum=(TextView)findViewById(R.id.activity_tool_time_of_other_sum);
        title_back= (ImageView) findViewById(R.id.title_back);
        title_back.setOnClickListener(this);
        activity_tool_time_of_other_begin.setOnClickListener(this);
        activity_tool_time_of_other_end.setOnClickListener(this);
    }
    private int now_year,now_month,now_day;
    private String date_begin="1900-01-01",date_end="1900-01-01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_time_of_other);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        Calendar c = Calendar.getInstance();
        now_year = c.get(Calendar.YEAR);
        now_month = c.get(Calendar.MONTH);
        now_day = c.get(Calendar.DAY_OF_MONTH);
        date_begin=String.format("%04d-%02d-%02d", now_year, now_month + 1, now_day);
        date_end=String.format("%04d-%02d-%02d", now_year, now_month + 1, now_day);
        activity_tool_time_of_other_begin.setText(date_begin);
        activity_tool_time_of_other_end.setText(date_end);
        activity_tool_time_of_other_sum.setText(String.format("%s",(int)getdayCount(date_begin, date_end)));
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.activity_tool_time_of_other_begin:
                Calendar c = Calendar.getInstance();
                now_year = c.get(Calendar.YEAR);
                now_month = c.get(Calendar.MONTH);
                now_day = c.get(Calendar.DAY_OF_MONTH);
                    new DatePickerDialog(Tool_time_of_other_Avtivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            activity_tool_time_of_other_begin.setText(String.format("%04d-%02d-%02d",year,monthOfYear+1,dayOfMonth));
                            date_begin=String.format("%04d-%02d-%02d",year,monthOfYear+1,dayOfMonth);
                            activity_tool_time_of_other_sum.setText(String.format("%s",(int)getdayCount(date_begin, date_end)));
                        }
                    },now_year,now_month,now_day).show();

                break;
            case R.id.activity_tool_time_of_other_end:
                    new DatePickerDialog(Tool_time_of_other_Avtivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            activity_tool_time_of_other_end.setText(String.format("%04d-%02d-%02d",year,monthOfYear+1,dayOfMonth));
                            date_end=String.format("%04d-%02d-%02d",year,monthOfYear+1,dayOfMonth);
                            activity_tool_time_of_other_sum.setText(String.format("%s",(int)getdayCount(date_begin, date_end)));
                        }
                    },now_year,now_month,now_day).show();
                break;
            case R.id.title_back:
                finish();
                break;
        }
    }
    public double getdayCount(String oneDay, String anotherDay) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// 输入日期的格式
        Date date1 = null,date2 = null;
        try {
            date1 = simpleDateFormat.parse(oneDay);
            date2 = simpleDateFormat.parse(anotherDay);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        GregorianCalendar cal1 = new GregorianCalendar();
        GregorianCalendar cal2 = new GregorianCalendar();
        cal1.setTime(date1);
        cal2.setTime(date2);
        double dayCount = (cal2.getTimeInMillis() - cal1.getTimeInMillis())/ (1000 * 3600 * 24);// 从间隔毫秒变成间隔天数
        // 取绝对值
        return Math.abs(dayCount);
    }

    @NonNull
    @Override
    public Tool_time_of_other_Presenter createPresenter() {
        return new Tool_time_of_other_Presenter();
    }
}
