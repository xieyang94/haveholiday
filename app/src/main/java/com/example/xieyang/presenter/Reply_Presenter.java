package com.example.xieyang.presenter;

import com.example.xieyang.entity.ReplyItemContent;
import com.example.xieyang.net.NetWork;
import com.example.xieyang.respmodule.ReplyRespData;
import com.example.xieyang.utils.ShowLog;
import com.example.xieyang.view.Reply_View;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/7/23.
 */
public class Reply_Presenter extends MvpBasePresenter<Reply_View>{
    protected Subscription subscription;
    private  int code ;
    private List<ReplyItemContent> replyItemContents;
    private Map<String, Object> body = new HashMap<>();
    private String reStr;

    private Observer<ReplyRespData> showReplyList= new Observer<ReplyRespData>() {
        @Override
        public void onNext(ReplyRespData respData) {
            code = respData.code;
            replyItemContents = respData.data;
            ShowLog.showTag(replyItemContents.size()+"-----------------答案是多少？-------------");
        }
        @Override
        public void onCompleted() {
            switch (code){
                case 200:
                    getView().showData(replyItemContents);
                    getView().successRefresh();
                    getView().hideLoading();

                    break;

                case 404:
                    getView().showLoading();
                    getView().successRefresh();
                    break;
            }

        }
        @Override
        public void onError(Throwable e) {
            getView().hideLoading();
            getView().failedLink();
            getView().successRefresh();
            ShowLog.showTag(e.toString() + "服务器请求失败或者服务器异常!!!--------Login_Presenter");
        }
    };


    public void showreplyList(String pushfestivalID,int upCount) {
        unsubscribe(subscription);
        body.clear();
        int i = Integer.parseInt(pushfestivalID);
        body.put("reply.pushedFestivalID", i);
        body.put("upCount", upCount);
        subscription = NetWork.getUserService().replylistShow(body).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(showReplyList);

    }

    protected void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
