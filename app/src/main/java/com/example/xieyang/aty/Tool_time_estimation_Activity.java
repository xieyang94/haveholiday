package com.example.xieyang.aty;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.demo3.R;
import com.example.xieyang.base.BaseActivity;
import com.example.xieyang.presenter.Tool_time_estimation_Presenter;
import com.example.xieyang.utils.DateUtils;
import com.example.xieyang.utils.OtherUtils;
import com.example.xieyang.view.Tool_time_estimation_View;

import java.util.Calendar;

public class Tool_time_estimation_Activity extends BaseActivity<Tool_time_estimation_View,Tool_time_estimation_Presenter> implements Tool_time_estimation_View,View.OnClickListener{

    private ImageView title_back;
    private EditText estimation_day_count;
    private TextView estimation_up,estimation_down,estimation_date,getDate;

    private int now_year,now_month,now_day;
    private String date_begin="1900-01-01";

    private OtherUtils otherUtils;

    private DateUtils dateUtils;

    public void init(){
        title_back= (ImageView) findViewById(R.id.title_back);
        title_back.setOnClickListener(this);
        estimation_day_count= (EditText) findViewById(R.id.estimation_day_count);
        estimation_up= (TextView) findViewById(R.id.estimation_up);
        estimation_up.setOnClickListener(this);
        estimation_down= (TextView) findViewById(R.id.estimation_down);
        estimation_down.setOnClickListener(this);
        estimation_date= (TextView) findViewById(R.id.estimation_date);
        getDate= (TextView) findViewById(R.id.getDate);
        getDate.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_time_estimation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        Calendar c = Calendar.getInstance();
        now_year = c.get(Calendar.YEAR);
        now_month = c.get(Calendar.MONTH);
        now_day = c.get(Calendar.DAY_OF_MONTH);
        date_begin=String.format("%04d-%02d-%02d", now_year, now_month + 1, now_day);
        getDate.setText(date_begin);
        otherUtils.hideL(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.estimation_up:
                estimation_date.setText(dateUtils.upDate(date_begin, Integer.valueOf(changeEdittext(estimation_day_count.getText().toString()))));
                otherUtils.hideL(this);
                break;
            case R.id.estimation_down:
                estimation_date.setText(dateUtils.upDate(date_begin, -Integer.valueOf(changeEdittext(estimation_day_count.getText().toString()))));
                otherUtils.hideL(this);
                break;
            case R.id.getDate:
                Calendar c = Calendar.getInstance();
                now_year = c.get(Calendar.YEAR);
                now_month = c.get(Calendar.MONTH);
                now_day = c.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(Tool_time_estimation_Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        getDate.setText(String.format("%04d-%02d-%02d",year,monthOfYear+1,dayOfMonth));
                        date_begin=String.format("%04d-%02d-%02d",year,monthOfYear+1,dayOfMonth);
                    }
                },now_year,now_month,now_day).show();
                break;
        }
    }
    //如果输入为空，则返回0
    public String changeEdittext(String str){
        if(str.equals("")||str==null){
            return "0";
        }else{
            return str;
        }
    }

    @NonNull
    @Override
    public Tool_time_estimation_Presenter createPresenter() {
        return new Tool_time_estimation_Presenter();
    }
}
