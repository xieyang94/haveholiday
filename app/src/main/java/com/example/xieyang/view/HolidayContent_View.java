package com.example.xieyang.view;

import com.example.xieyang.entity.Festival;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Administrator on 2016/7/24.
 */
public interface HolidayContent_View extends MvpView {

    /**
     * 获取成功，显示
     */
    void getFestival(int code,Festival data);

    /**
     * 加载时显示进度圈
     */
    void showLoading();

    /**
     * 加载完成，隐藏进度圈
     */
    void hideLoading();
    /**
     * 连接服务器失败
     */
    void failedLink();
}
