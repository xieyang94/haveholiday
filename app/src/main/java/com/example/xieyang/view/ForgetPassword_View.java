package com.example.xieyang.view;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Administrator on 2016/7/23.
 */
public interface ForgetPassword_View extends MvpView {

    /**
     * 修改新密码成功
     */
    void successforget();
    /**
     * 修改新密码失败
     */
    void failedforget();
    /**
     * 验证码发送成功
     */
    void successcode();
    /**
     * 验证码发送失败
     */
    void failedcode();
    /**
     * 连接服务器失败
     */
    void failedLink();

    /**
     * 两次输入的密码不一样
     */
    void notSamePwd();

    /**
     * 邮箱、密码没有输入完全
     */
    void nullValue();

    /**
     * 再次输入密码为空
     */
    void nullPasswordAgain();

    /**
     * 邮箱格式不对
     */
    void failedEmail();

    /**
     * 密码长度不对，需6~10位
     */
    void failedPasswordLength();
    /**
     * 加载时显示进度圈
     */
    void showLoading();

    /**
     * 加载完成，隐藏进度圈
     */
    void hideLoading();
}
