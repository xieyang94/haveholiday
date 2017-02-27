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
import com.example.xieyang.presenter.Tool_other_festival_Presenter;
import com.example.xieyang.view.Tool_other_festival_View;

import java.util.ArrayList;
import java.util.List;

public class Tool_other_festival_Activity extends BaseActivity<Tool_other_festival_View,Tool_other_festival_Presenter> implements Tool_other_festival_View,View.OnClickListener {
    private ListView other_festival_list;
    private ArrayAdapter<String> adapter;        //定义一个适配器
    List<String> arr=new ArrayList<String>();    //定义一个适配器列表
    private ImageView title_back;
    public void init() {
        other_festival_list=(ListView)findViewById(R.id.other_festival_list);         //寻址
        title_back= (ImageView) findViewById(R.id.title_back);
        title_back.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_other_festival);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       init();
        arr.add("联合国卫塞节"+"      "+"5月满月之日");                    //往列表里添加字符串
        arr.add("复活节"+"      "+"春分月圆后第一个星期日");                    //往列表里添加字符串
        arr.add("寒食节"+"      "+"冬至日后105日清明节前一日");                    //往列表里添加字符串
        arr.add("耶稣受难日"+"      "+"复活节前的星期五");                    //往列表里添加字符串
        arr.add("春社日"+"      "+"立春后第五个戊日");                    //往列表里添加字符串

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arr);  //获取适配器类型
        other_festival_list.setAdapter(adapter);                      //呈现
        other_festival_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Tool_other_festival_Activity.this, HolidayContent_Avtivity.class);
                intent.putExtra("holiday", "" + arr.get(position));
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
    public Tool_other_festival_Presenter createPresenter() {
        return new Tool_other_festival_Presenter();
    }
}
