package com.example.xieyang.presenter;

import android.util.Log;

import com.example.xieyang.Config;
import com.example.xieyang.entity.ReplyItemContent;
import com.example.xieyang.net.NetWork;
import com.example.xieyang.respmodule.RespDataStr;
import com.example.xieyang.utils.ShowLog;
import com.example.xieyang.view.SquareContent_View;
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
public class SquareContent_Presenter extends MvpBasePresenter<SquareContent_View> {

    protected Subscription subscription;
    private  int code ;
    private List<ReplyItemContent> replyItemContents;
    private Map<String, Object> body = new HashMap<>();
    private String reStr;

    private Observer<RespDataStr> showReplyCount= new Observer<RespDataStr>() {
        @Override
        public void onNext(RespDataStr respData) {
            code = respData.code;
            reStr = respData.data;
//            Config.replyCount=Integer.parseInt(reStr);

            Log.d("TAG","回复总数；"+reStr);

        }
        @Override
        public void onCompleted() {
            switch (code){
                case 200:
                    Log.d("TAG","回复总数------------efee---；"+reStr);
                    getView().hideLoading();
                    getView().showReplyCount(reStr);
                    break;
                case 404:
                    getView().showLoading();
                    break;
            }

        }
        @Override
        public void onError(Throwable e) {
            getView().hideLoading();
            ShowLog.showTag(e.toString() + "服务器请求失败或者服务器异常!!!--------SquareContent_Presenter1");
        }
    };


    public void showreplyCount(String pushfestivalID) {
        unsubscribe(subscription);
        body.clear();
        int i = Integer.parseInt(pushfestivalID);
        body.put("reply.pushedFestivalID", i);
        subscription = NetWork.getUserService().replycountShow(body).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(showReplyCount);

    }


    /**
     * 送花
     * @param subscription
     */
    protected Subscription subscription1;
    private  int code1 ;
    private List<ReplyItemContent> replyItemContents1;
    private Map<String, Object> body1 = new HashMap<>();
    private String reStr1;

    private Observer<RespDataStr> showUpdateLikeCount= new Observer<RespDataStr>() {
        @Override
        public void onNext(RespDataStr respData) {
            code1 = respData.code;
            reStr1 = respData.data;

        }
        @Override
        public void onCompleted() {
            switch (code1){
                case 200:
//                    getView().hideLoading();
                    break;
                case 404:
//                    getView().showLoading();
                    break;
            }

        }
        @Override
        public void onError(Throwable e) {
//            getView().hideLoading();
            ShowLog.showTag(e.toString() + "服务器请求失败或者服务器异常!!!--------SquareContent_Presenter2");
        }
    };


    public void showUpdateLikeCount(String pushfestivalID) {
        unsubscribe(subscription1);
        body1.clear();
        int i = Integer.parseInt(pushfestivalID);
        body1.put("pushedFestival.pushedFestivalId", i);
        subscription1 = NetWork.getUserService().updatelikecountShow(body1).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(showUpdateLikeCount);

    }
    /**
     * 验证身份
     * @param subscription
     */
    protected Subscription subscription2;
    private  int code2 ;
    private List<ReplyItemContent> replyItemContents2;
    private Map<String, String> body2 = new HashMap<>();
    private String reStr2;

    private Observer<RespDataStr> checkToken= new Observer<RespDataStr>() {
        @Override
        public void onNext(RespDataStr respData) {
            code2 = respData.code;
            reStr2 = respData.data;
            ShowLog.showTag("获取数据成功on--------------回复总数");

        }
        @Override
        public void onCompleted() {
            switch (code2){
                case 200:
//                    getView().hideLoading();
                    Config.checkUserToken=true;
                    break;
                case 404:
                    Config.checkUserToken=false;
//                    getView().showLoading();
                    getView().twoUser();
                    break;
            }

        }
        @Override
        public void onError(Throwable e) {
//            getView().hideLoading();
            ShowLog.showTag(e.toString() + "服务器请求失败或者服务器异常!!!--------SquareContent_Presenter3");
        }
    };


    public void checkToken(String id,String pwd,String token) {
        unsubscribe(subscription2);
        body2.clear();
        body2.put("user.userEmail", id);
        body2.put("user.userPassword", pwd);
        body2.put("user.token",token);
        subscription2 = NetWork.getUserService().checkTokens(body2).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(checkToken);

    }

    protected void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }


}
