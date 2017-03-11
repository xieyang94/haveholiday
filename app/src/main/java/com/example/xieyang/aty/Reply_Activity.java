package com.example.xieyang.aty;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.demo3.R;
import com.example.xieyang.Config;
import com.example.xieyang.adapter.Reply_Adapter;
import com.example.xieyang.base.BaseActivity;
import com.example.xieyang.entity.ReplyItemContent;
import com.example.xieyang.evenbus.UpdateEven;
import com.example.xieyang.presenter.Reply_Presenter;
import com.example.xieyang.utils.PTRUtil;
import com.example.xieyang.utils.ShowLog;
import com.example.xieyang.view.Reply_View;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class Reply_Activity extends BaseActivity<Reply_View,Reply_Presenter> implements Reply_View,View.OnClickListener{
//    private ListView list_reply;
    private ImageView title_back;
    private LinearLayout write_reply;
    private String pushedfestivalId;
    List<ReplyItemContent> replys=new ArrayList<>();
    public Reply_Adapter reply_adapter;
    private PullToRefreshListView mListView;

    private int upCount=10;
    private static int downCount=10;
    private static int othersize=0;

    private PTRUtil ptrUtil;


//    private static SwipeRefreshLayout mSwipeLayout;
    private ProgressDialog pd = null;

    private void init() {
//        list_reply = (ListView) findViewById(R.id.list_reply);
//        write_reply=(LinearLayout) findViewById(R.id.write_reply);
//        mSwipeLayout = (SwipeRefreshLayout)findViewById(R.id.id_swipe_ly);
        title_back= (ImageView) findViewById(R.id.title_back);
        title_back.setOnClickListener(this);
//        mSwipeLayout.setOnRefreshListener(this);
        pd = new ProgressDialog(this);
        pd.setMessage("正在加载……");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        EventBus.getDefault().register(this);

        init();


        mListView = (PullToRefreshListView) findViewById(R.id.list_view);

        pd.show();
        //设置下拉刷新转圈的颜色
//        mSwipeLayout.setColorSchemeResources(R.color.red, R.color.black, R.color.geek_green, R.color.bg_grey);
        reply_adapter=new Reply_Adapter(this, replys);
//        list_reply.setAdapter(reply_adapter);
        mListView.setAdapter(reply_adapter);
        pushedfestivalId=getIntent().getStringExtra("push_festival_ID");
        ShowLog.showTag("评论界面------->当前推送节日ID" + pushedfestivalId);
        ShowLog.showTag(Config.UPLIST+"-----------------------------------------------------------------");
       getPresenter().showreplyList(pushedfestivalId,upCount);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Reply_Activity.this, ReplyContent_Activity.class);
                intent.putExtra("push_festival_ID", "" + pushedfestivalId);//把推送条目的ID传过去
                startActivity(intent);
            }
        });

          ptrUtil.setPTRText(mListView);

        // 设置PullToRefresh
        mListView.setMode(PullToRefreshBase.Mode.BOTH);
        mListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {

            // 下拉Pulling Down
            @Override
            public void onPullDownToRefresh(
                    PullToRefreshBase<ListView> refreshView) {
                // 下拉的时候操作

                downCount=10;
                replys.clear();
                getPresenter().showreplyList(pushedfestivalId,upCount);
                Config.replyCount=replys.size();

                reply_adapter.notifyDataSetChanged();

                new FinishRefresh().execute();
            }

            // 上拉Pulling Up
            @Override
            public void onPullUpToRefresh(
                    PullToRefreshBase<ListView> refreshView) {
                // 上拉的时候操作
                Config.replyCount=replys.size();
                ShowLog.showTag(Config.replyCount+"-----------Config.replyCount测试数据------------------------------");
                ShowLog.showTag(othersize+"-----------othersize测试数据------------------------------");
                if(othersize==0){
                    downCount=Config.replyCount+10;
                }else {
                    downCount += 10;
                    ShowLog.showTag(downCount+"--------------downCount测试数据1----------------------");
                }
//                replys.clear();
                ShowLog.showTag(downCount+"--------------downCount测试数据2----------------------");
                getPresenter().showreplyList(pushedfestivalId,downCount);


                reply_adapter.notifyDataSetChanged();

                new FinishRefresh().execute();
            }

        });

    }

    private class FinishRefresh extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            mListView.onRefreshComplete();
        }
    }

    @Override
    public void showData(List<ReplyItemContent> listReplyContent) {
        for (ReplyItemContent m:  listReplyContent) {
            replys.add(m);
        }
        ShowLog.showTag("showData  "+listReplyContent.size()+" ----- "+replys.size());
        Config.replyCount=replys.size();
        othersize=listReplyContent.size();
        reply_adapter.notifyDataSetChanged();
    }

    @Override
    public void successRefresh() {
//        mSwipeLayout.setRefreshing(false);
        ShowLog.showTag("完成");
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
        Toast.makeText(Reply_Activity.this, "连接不到服务器，或服务器异常", Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void onRefresh() {
//        replys.clear();
//        getPresenter().showreplyList(pushedfestivalId);
//        Config.replyCount=replys.size();
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }
    //通过广播刷新数据
    public static class MyListBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ShowLog.showTag("------------------通过广播刷新--------------------------");
//            downCount=Config.replyCount;
        }

    }

    @NonNull
    @Override
    public Reply_Presenter createPresenter() {
        return new Reply_Presenter();
    }

    @Subscribe
    public void updateList(UpdateEven updateEven){
        downCount=10;
        replys.clear();

        getPresenter().showreplyList(pushedfestivalId,upCount);

    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
