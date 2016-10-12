package com.example.xieyang.utils;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

/**
 * Created by Administrator on 2016/8/16.
 */
public class PTRUtil {
    public static void setPTRText(PullToRefreshBase ptrView) {
        ptrView.setMode(PullToRefreshBase.Mode.BOTH);
        ILoadingLayout startLabels = ptrView.getLoadingLayoutProxy(true, false);
        startLabels.setPullLabel("下拉刷新");
        startLabels.setRefreshingLabel("正在刷新...");
        startLabels.setReleaseLabel("松开刷新");

        ILoadingLayout endLabels = ptrView.getLoadingLayoutProxy(false, true);
        endLabels.setPullLabel("上拉加载");
        endLabels.setRefreshingLabel("正在加载...");
        endLabels.setReleaseLabel("加载更多");
        ptrView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
    }
}
