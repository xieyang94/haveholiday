package com.example.xieyang.view;

import com.example.xieyang.entity.PushedFestival;
import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/7/23.
 */
public interface Frag_3_View extends MvpView {

    void showData(List<PushedFestival> listPushedFestival);
    /**
     * 加载成功后刷新结束
     */
    void successRefresh();
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
