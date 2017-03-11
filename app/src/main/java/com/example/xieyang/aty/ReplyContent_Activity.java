package com.example.xieyang.aty;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.demo3.R;
import com.example.xieyang.Config;
import com.example.xieyang.base.BaseActivity;
import com.example.xieyang.evenbus.ReplyEven;
import com.example.xieyang.evenbus.UpdateEven;
import com.example.xieyang.presenter.ReplyContent_Presenter;
import com.example.xieyang.utils.ShowLog;
import com.example.xieyang.view.ReplyContent_View;

import org.greenrobot.eventbus.EventBus;

public class ReplyContent_Activity extends BaseActivity<ReplyContent_View, ReplyContent_Presenter> implements View.OnClickListener, ReplyContent_View {
    private String pushedfestivalId;
    private TextView replyContent_commit;
    private ImageView title_back;
    private EditText replyContent_content;

    public void init() {
        title_back = (ImageView) findViewById(R.id.title_back);
        replyContent_commit = (TextView) findViewById(R.id.replyContent_commit);
        replyContent_content = (EditText) findViewById(R.id.replyContent_content);
        title_back.setOnClickListener(this);
        replyContent_commit.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        pushedfestivalId = getIntent().getStringExtra("push_festival_ID");
        ShowLog.showTag(getPresenter() + "评论界面------->当前推送节日ID" + pushedfestivalId);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.replyContent_commit:
                /**
                 * 用户登录才可操作
                 */
                if (Config.USERGET == null || Config.USERGET.getUserEmail().equals("")) {

                    Toast.makeText(ReplyContent_Activity.this, "您还没有登录", Toast.LENGTH_SHORT).show();
                } else {
                    /**
                     * 点击了提交，后后台数据库操作
                     */
                    if (replyContent_content.getText().toString().equals("")) {
                        Toast.makeText(ReplyContent_Activity.this, "您好，您输入的内容为空!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        getPresenter().addReplyContentShow_s(replyContent_content.getText().toString(), pushedfestivalId, Config.USERGET.getUserEmail(), Config.USERGET.getToken());
                        finish();
                    }
                }

                break;
        }
    }

    @Override
    public void twoUser() {
        Toast.makeText(ReplyContent_Activity.this, "你好，你的账号已在别的设备登录，请退出重新登录！！！", Toast.LENGTH_SHORT).show();
    }

    //emoji表情是4个字符，存储不到数据库，暂时就不支持了
    @Override
    public void successReply() {
        Intent intent = new Intent();
        intent.setAction("com.xieyang.xieyang1");
        sendBroadcast(intent);
        Intent intent1 = new Intent();
        intent1.setAction("com.xieyang.xieyang2");
        sendBroadcast(intent1);
        EventBus.getDefault().post(new ReplyEven("回复+1"));
        Toast.makeText(ReplyContent_Activity.this, "评论成功", Toast.LENGTH_SHORT).show();
        EventBus.getDefault().post(new UpdateEven("更新评论"));
    }

    @NonNull
    @Override
    public ReplyContent_Presenter createPresenter() {
        return new ReplyContent_Presenter();
    }
}
