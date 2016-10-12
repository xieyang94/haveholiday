package com.example.xieyang.presenter;

import com.example.xieyang.Config;
import com.example.xieyang.aty.ReplyContent_Activity;
import com.example.xieyang.net.NetWork;
import com.example.xieyang.respmodule.RespDataStr;
import com.example.xieyang.view.ReplyContent_View;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/7/23.
 */
public class ReplyContent_Presenter extends MvpBasePresenter<ReplyContent_View> {

    protected Subscription subscription;
    private  int code ;
    private Map<String, Object> body = new HashMap<>();
    private String reStr;
    private ReplyContent_Activity replyContent_activity;

    private Observer<RespDataStr> addReplyContentShow_s= new Observer<RespDataStr>() {
        @Override
        public void onNext(RespDataStr respData) {
            code = respData.code;
            reStr = respData.data;
            Config.replyCount=Integer.parseInt(reStr);
            System.out.println("----------------------------------------reStr="+reStr);
        }
        @Override
        public void onCompleted() {
            switch (code){
                case 200:
                    //有错误 Attempt to invoke interface method 'void com.example.xieyang.view.ReplyContent_View.successReply()' on a null object reference
                    //妈的，什么意思啊
//                    getView().successReply();
                    //弱引用  http://www.androidchina.net/4530.html有一点解释
                    // 在Presenter中引用View时，一定要判断是否非空，因为这个View是WeakReference弱引用，不进行判断的话会产生空指针异常。
                    // 这是这个框架不好的地方，需要多次重复判空。
                    if(getView()==null){
                        System.out.println("评论成功，请下拉刷新查看!!!");
                    }else{
                        getView().successReply();
                    }
                    System.out.println("获取数据成功------------jintian今天");
                    break;
                case 404:
                    getView().twoUser();
                    System.out.println("获取数据失败--------------今天");
                    break;
            }

        }
        @Override
        public void onError(Throwable e) {
            System.out.println(e.toString() + "服务器请求失败或者服务器异常!!!--------ReplyContent_Presenter");
        }
    };


    public void addReplyContentShow_s(String replyContent,String pushfestivalID,String replyUserEmail,String token) {
        unsubscribe(subscription);
        body.clear();
        int i = Integer.parseInt(pushfestivalID);
        body.put("replyItemContent.replyItemContent", replyContent);
        body.put("replyItemContent.replyPushedFestivalID", i);
        body.put("replyItemContent.replyUserID",replyUserEmail);
        body.put("replyItemContent.token",token);
        subscription = NetWork.getUserService().addReplyContentShow(body).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(addReplyContentShow_s);

    }

    protected void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
