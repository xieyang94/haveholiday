package com.example.xieyang.view;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Administrator on 2016/7/23.
 */
public interface SquareContent_View extends MvpView {
    void showReplyCount(String str);

    /**
     * 加载时显示进度圈
     */
    void showLoading();

    /**
     * 加载完成，隐藏进度圈
     */
    void hideLoading();
    void twoUser();
}
