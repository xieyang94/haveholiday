package com.example.xieyang.aty;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.demo3.R;
import com.example.xieyang.Config;
import com.example.xieyang.base.BaseActivity;
import com.example.xieyang.evenbus.ReplyEven;
import com.example.xieyang.presenter.SquareContent_Presenter;
import com.example.xieyang.utils.ResultNull;
import com.example.xieyang.utils.ShowLog;
import com.example.xieyang.utils.ToSampleTime;
import com.example.xieyang.view.SquareContent_View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class SquareContent_Activity extends BaseActivity<SquareContent_View, SquareContent_Presenter> implements SquareContent_View ,View.OnClickListener{
    private ImageView pf_ContentBg,title_back,pf_Content2, pf_Content4 , pf_Content6;
    private TextView pf_ContentTitle,pf_Content,pf_Content3, pf_Content5, pf_Content7;
    private TextView pf_Time,like_Count;
    private static TextView reply_Count;

    private LinearLayout content_layout;
    private LinearLayout reply,like_State;
    private String pushedfestivalId,pushedfestivalContentBg,pushedfestivalContentTitle;
    private String pushedfestivalContent,pushedfestivalContent2,pushedfestivalContent3;
    private String pushedfestivalContent4,pushedfestivalContent5,pushedfestivalContent6,pushedfestivalContent7;
    private String replyID,replyCount,likeState,likeCount,pushfestivalTime;

    public ToSampleTime toSampleTime;

    public ResultNull resultNull;
    public static int likeCount_i;
    public static int likeState_i;

    private ProgressDialog pd = null;

    private void init() {
        pf_ContentBg = (ImageView) findViewById(R.id.pf_ContentBg);
        pf_ContentTitle = (TextView) findViewById(R.id.pf_ContentTitle);
        pf_Content = (TextView) findViewById(R.id.pf_Content);
        pf_Content2 = (ImageView) findViewById(R.id.pf_Content2);
        pf_Content3 = (TextView) findViewById(R.id.pf_Content3);
        pf_Content4 = (ImageView) findViewById(R.id.pf_Content4);
        pf_Content5 = (TextView) findViewById(R.id.pf_Content5);
        pf_Content6 = (ImageView) findViewById(R.id.pf_Content6);
        pf_Content7 = (TextView) findViewById(R.id.pf_Content7);
        pf_Time = (TextView) findViewById(R.id.pf_Time);
        like_State = (LinearLayout) findViewById(R.id.like_State);
        reply_Count = (TextView) findViewById(R.id.reply_Count);
        like_Count = (TextView) findViewById(R.id.like_Count);

        content_layout = (LinearLayout) findViewById(R.id.content_layout);
        reply = (LinearLayout) findViewById(R.id.reply);
        title_back= (ImageView) findViewById(R.id.title_back);
        title_back.setOnClickListener(this);

        pd = new ProgressDialog(this);
        pd.setMessage("正在加载内容……");
    }

    public void getfromIntent() {
        pushedfestivalId = getIntent().getStringExtra("push_festival_ID");
        pushedfestivalContentBg = getIntent().getStringExtra("pushed_festival_ContentBg");
        pushedfestivalContentTitle = getIntent().getStringExtra("pushed_festival_Content_Title");
        pushedfestivalContent = getIntent().getStringExtra("pushed_festival_Content");
        pushedfestivalContent2 = getIntent().getStringExtra("pushed_festival_Content2");
        pushedfestivalContent3 = getIntent().getStringExtra("pushed_festival_Content3");
        pushedfestivalContent4 = getIntent().getStringExtra("pushed_festival_Content4");
        pushedfestivalContent5 = getIntent().getStringExtra("pushed_festival_Content5");
        pushedfestivalContent6 = getIntent().getStringExtra("pushed_festival_Content6");
        pushedfestivalContent7 = getIntent().getStringExtra("pushed_festival_Content7");
        replyID = getIntent().getStringExtra("reply_ID");
        replyCount = getIntent().getStringExtra("reply_Count");
        likeState = getIntent().getStringExtra("like_State");
        likeCount = getIntent().getStringExtra("like_Count");
        pushfestivalTime = getIntent().getStringExtra("push_festival_Time");

    }

    public void showPFContent() {
        Glide
                .with(SquareContent_Activity.this)
                .load(pushedfestivalContentBg)
                .centerCrop()//CenterCrop()是一个裁剪技术，即缩放图像让它填充到 ImageView 界限内并且侧键额外的部分
//                .error(R.mipmap.error)//加载失败时，显示默认图片
                .into(pf_ContentBg);
        pf_ContentTitle.setText("" + resultNull.solveNull(pushedfestivalContentTitle));
        if(resultNull.solveNull(pushedfestivalContent).equals("")){pf_Content.setVisibility(View.GONE);}
        else {
            pf_Content.setText("" + resultNull.solveNull(pushedfestivalContent));
        }
        if(resultNull.solveNull(pushedfestivalContent2).equals("")){pf_Content2.setVisibility(View.GONE);}
        else {
            Glide
                    .with(SquareContent_Activity.this)
                    .load(resultNull.solveNull(pushedfestivalContent2))
                    .centerCrop()
                    .into(pf_Content2);
        }
        if(resultNull.solveNull(pushedfestivalContent3).equals("")){pf_Content3.setVisibility(View.GONE);}
        else {
            pf_Content3.setText("" + resultNull.solveNull(pushedfestivalContent3));
        }
        if(resultNull.solveNull(pushedfestivalContent4).equals("")){pf_Content4.setVisibility(View.GONE);}
        else {
            Glide
                    .with(SquareContent_Activity.this)
                    .load(resultNull.solveNull(pushedfestivalContent4))
                    .centerCrop()
                    .into(pf_Content4);
        }
        if(resultNull.solveNull(pushedfestivalContent5).equals("")){pf_Content5.setVisibility(View.GONE);}
        else {
            pf_Content5.setText("" + resultNull.solveNull(pushedfestivalContent5));
        }
        if(resultNull.solveNull(pushedfestivalContent6).equals("")){pf_Content6.setVisibility(View.GONE);}
        else {
            Glide
                    .with(SquareContent_Activity.this)
                    .load(resultNull.solveNull(pushedfestivalContent6))
                    .centerCrop()
                    .into(pf_Content6);
        }
        if(resultNull.solveNull(pushedfestivalContent7).equals("")){pf_Content7.setVisibility(View.GONE);}
        else {
            pf_Content7.setText("" + resultNull.solveNull(pushedfestivalContent7));
        }
        pf_Time.setText("" + toSampleTime.killMsec(pushfestivalTime));
        like_Count.setText("送花(" + likeCount + ")");
        reply_Count.setText("回复(" + replyCount + ")");
    }

    @Override
    public void showReplyCount(String str) {
        reply_Count.setText("回复(" + str + ")");
        Config.replyCount=Integer.parseInt(str);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EventBus.getDefault().register(this);
        init();
        pd.show();
        getfromIntent();
        likeCount_i=Integer.parseInt(likeCount);
        likeState_i=Integer.parseInt(likeState);
        getPresenter().showreplyCount(pushedfestivalId);
        if(Config.USERGET==null){}
        else {
            getPresenter().checkToken(Config.USERGET.getUserEmail(), Config.USERGET.getUserPassword(), Config.USERGET.getToken());
        }
        showPFContent();
        ShowLog.showTag("推送节日内容界面------->当前推送节日ID" + pushedfestivalId + pushfestivalTime);
        reply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SquareContent_Activity.this, Reply_Activity.class);
                intent.putExtra("push_festival_ID", pushedfestivalId);
                startActivity(intent);
            }
        });
        //点赞的状态及其点赞的总数
        like_State.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.判断用户是否处于登录状态，如果非登录，则不可点赞
                if (Config.USERGET == null||Config.USERGET.getUserEmail().equals("")) {
                    Toast.makeText(SquareContent_Activity.this, "尊敬的用户您好，您还没有登录!!!", Toast.LENGTH_SHORT).show();
                }else {
                    /**
                     * 如果当前的登录用户登录唯一，则执行if语句
                     */
                    if(Config.checkUserToken){
                        if (Config.SENDTIME < 3) {
                            likeCount_i = likeCount_i + 1;
                            like_Count.setText("送花(" + likeCount_i + ")");
                            TextPaint like_Count_paint = like_Count.getPaint();//设置字体为粗体
                            like_Count_paint.setFakeBoldText(true);//
                            like_Count.setTextColor(Color.parseColor("#ff403c"));//设置字体颜色为红色
                            /**
                            * 后台数据库操作
                            */
                            getPresenter().showUpdateLikeCount(pushedfestivalId);
                            Config.SENDTIME++;
                        } else {
                            Toast.makeText(SquareContent_Activity.this, "登陆一次最多送3朵花哦！！！", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

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
    public void twoUser() {
        Toast.makeText(SquareContent_Activity.this, "你好，你的账号已在别的设备登录，请退出重新登录！！！", Toast.LENGTH_SHORT).show();
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
    public SquareContent_Presenter createPresenter() {
        return new SquareContent_Presenter();
    }


    //通过广播刷新回复数据
    public static class MyListBroadcastReceiver1 extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ShowLog.showTag("TAG","------------------通过广播刷新--------------------------Config.replyCount="+Config.replyCount);
//            downCount=Config.replyCount;
            reply_Count.setText("回复(" + Config.replyCount + ")");
        }

    }

    /**
     * 回复成功后，数据+1
     * @param replyEven
     */
    @Subscribe
    public void on(ReplyEven replyEven){
        int times=Config.replyCount+1;
        reply_Count.setText("回复(" + times + ")");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//反注册EventBus
    }
}
