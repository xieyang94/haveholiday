package com.example.xieyang.view;

import com.example.xieyang.entity.User;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Administrator on 2016/7/23.
 */
public interface Login_View extends MvpView{

    void cplLogin(int code, User data);
    void fLogin();//登录失败
    void failedLink();
    void successLogin();
    /**
     * 加载时显示进度圈
     */
    void showLoading();

    /**
     * 加载完成，隐藏进度圈
     */
    void hideLoading();

    /**
     * 账号为空
     */
    void nullId();

    /**
     * 密码为空
     */
    void nullPwd();

}
