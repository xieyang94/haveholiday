package com.example.xieyang.view;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Administrator on 2016/7/25.
 */
public interface MainActivity_View extends MvpView {

    /**
     * 在别的设备登录
     */
    void twoUser(int code);
    /**
     * 更换成功
     */
    void successChangeHeadPicture(String str);

}
