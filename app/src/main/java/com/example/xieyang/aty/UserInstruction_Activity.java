package com.example.xieyang.aty;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.demo3.R;
import com.example.xieyang.presenter.UserInstruction_Presenter;
import com.example.xieyang.view.UserInstruction_View;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

public class UserInstruction_Activity extends MvpActivity<UserInstruction_View,UserInstruction_Presenter> implements UserInstruction_View,View.OnClickListener {

    private ImageView title_back;
    private void init(){
        title_back= (ImageView) findViewById(R.id.title_back);
        title_back.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_instruction_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
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
    public UserInstruction_Presenter createPresenter() {
        return new UserInstruction_Presenter();
    }
}
