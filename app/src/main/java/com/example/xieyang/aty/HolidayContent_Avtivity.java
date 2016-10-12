package com.example.xieyang.aty;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.demo3.R;
import com.example.xieyang.Config;
import com.example.xieyang.common.BaseActivity;
import com.example.xieyang.entity.Festival;
import com.example.xieyang.presenter.HolidayContent_Presenter;
import com.example.xieyang.utils.ResultNull;
import com.example.xieyang.view.HolidayContent_View;

import java.util.StringTokenizer;

public class HolidayContent_Avtivity extends BaseActivity<HolidayContent_View,HolidayContent_Presenter> implements HolidayContent_View,View.OnClickListener{

    private TextView holiday_title;
    private TextView festival_content_textview,festival_content_textview2,festival_content_textview3,festival_content_textview4,festival_content_textview5,festival_content_textview6,festival_content_textview7;
    private ImageView festival_picture_bg,title_back;
    private String str="";
    private String contentStr="",contentStr2="",contentStr3="",contentStr4="",contentStr5="",contentStr6="",contentStr7="";
    private int i=0;
    private String[] festival_arr=new String[2];
    private ProgressDialog pd = null;
    public  ResultNull resultNull;
    public void init(){
        holiday_title= (TextView) findViewById(R.id.holiday_title);
        festival_picture_bg= (ImageView) findViewById(R.id.festival_picture_bg);
        festival_content_textview= (TextView) findViewById(R.id.festival_content_textview);
        festival_content_textview2= (TextView) findViewById(R.id.festival_content_textview2);
        festival_content_textview3= (TextView) findViewById(R.id.festival_content_textview3);
        festival_content_textview4= (TextView) findViewById(R.id.festival_content_textview4);
        festival_content_textview5= (TextView) findViewById(R.id.festival_content_textview5);
        festival_content_textview6= (TextView) findViewById(R.id.festival_content_textview6);
        festival_content_textview7= (TextView) findViewById(R.id.festival_content_textview7);
        title_back= (ImageView) findViewById(R.id.title_back);
        title_back.setOnClickListener(this);
        pd = new ProgressDialog(this);
        pd.setMessage("正在加载……");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday_content__avtivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        pd.show();//未加载成功时，显示进度圈
        str = getIntent().getStringExtra("holiday");

        holiday_title.setText(str);

        StringTokenizer st = new StringTokenizer(str, "     ");
        while (st.hasMoreTokens()) {
            festival_arr[i]=st.nextToken();
            i++;
//            arr.add(st.nextToken() + "      " + str + "月" + i + "日");
        }
        System.out.println("festival_arr[0]=" + festival_arr[0] + "festival_arr[1]=" + festival_arr[1] + "-----------------+++++++++++");

        getPresenter().showFestival(festival_arr[0], festival_arr[1]);
//        festival_content_textview.setText("" + Config.FESTIVALGET.getFestivalContent());
//        showGet();
    }

    @Override
    public void getFestival(int code, Festival data) {
        contentStr=resultNull.solveNull(Config.FESTIVALGET.getFestivalContent());
        contentStr2=resultNull.solveNull(Config.FESTIVALGET.getFestivalContent2());
        contentStr3=resultNull.solveNull(Config.FESTIVALGET.getFestivalContent3());
        contentStr4=resultNull.solveNull(Config.FESTIVALGET.getFestivalContent4());
        contentStr5=resultNull.solveNull(Config.FESTIVALGET.getFestivalContent5());
        contentStr6=resultNull.solveNull(Config.FESTIVALGET.getFestivalContent6());
        contentStr7=resultNull.solveNull(Config.FESTIVALGET.getFestivalContent7());
        if(contentStr.equals("")){festival_content_textview.setVisibility(View.GONE);}
        else {festival_content_textview.setText(contentStr);}
        if(contentStr2.equals("")){festival_content_textview2.setVisibility(View.GONE);}
        else {festival_content_textview2.setText(contentStr2);}
        if(contentStr3.equals("")){festival_content_textview3.setVisibility(View.GONE);}
        else {festival_content_textview3.setText(contentStr3);}
        if(contentStr4.equals("")){festival_content_textview4.setVisibility(View.GONE);}
        else {festival_content_textview4.setText(contentStr4);}
        if(contentStr5.equals("")){festival_content_textview5.setVisibility(View.GONE);}
        else {festival_content_textview5.setText(contentStr5);}
        if(contentStr6.equals("")){festival_content_textview6.setVisibility(View.GONE);}
        else {festival_content_textview6.setText(contentStr6);}
        if(contentStr7.equals("")){festival_content_textview7.setVisibility(View.GONE);}
        else {festival_content_textview7.setText(contentStr7);}
//        if(Config.FESTIVALGET.getFestivalContent7()==null){
//            festival_content_textview7.setText("");
//        }else {
//            festival_content_textview7.setText("" + Config.FESTIVALGET.getFestivalContent7());
//        }
//            String internetUrl = "http://i.imgur.com/DvpvklR.png";
        String internetUrl =Config.FESTIVALGET.getFestivalPicture();

        Glide
                .with(HolidayContent_Avtivity.this)
                .load(internetUrl)
                .centerCrop()//CenterCrop()是一个裁剪技术，即缩放图像让它填充到 ImageView 界限内并且侧键额外的部分
                .into(festival_picture_bg);
    }

    //个人信息界面显示个人信息
    public void showGet(){
        if(Config.FESTIVALGET.getFestivalContent()==null){
        }
        else{
            festival_content_textview.setText(""+Config.FESTIVALGET.getFestivalContent());
        }
        //图片设置
        if(Config.FESTIVALGET.getFestivalPicture()==null){
        }else{
//            Config.FESTIVALGET.getFestivalContent()
//            String internetUrl = "http://i.imgur.com/DvpvklR.png";
            String internetUrl =Config.FESTIVALGET.getFestivalPicture();

            Glide
                    .with(HolidayContent_Avtivity.this)
                    .load(internetUrl)
                    .into(festival_picture_bg);

        }
    }


    @Override
    public void showLoading() {
        pd.show();
    }

    @Override
    public void hideLoading() {
        pd.cancel();
    }

    @Override
    public void failedLink() {
        Toast.makeText(HolidayContent_Avtivity.this,"连接不到服务器，或服务器异常",Toast.LENGTH_SHORT).show();
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
    public HolidayContent_Presenter createPresenter() {
        return new HolidayContent_Presenter();
    }
}
