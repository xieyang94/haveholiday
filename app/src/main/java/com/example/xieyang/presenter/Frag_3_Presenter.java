package com.example.xieyang.presenter;

import com.example.xieyang.entity.PushedFestival;
import com.example.xieyang.net.NetWork;
import com.example.xieyang.respmodule.PushedFestivalRespData;
import com.example.xieyang.view.Frag_3_View;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.ArrayList;
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
public class Frag_3_Presenter extends MvpBasePresenter<Frag_3_View> {
    protected Subscription subscription;
    private int code;
    private List<PushedFestival> pushedFestivals_list;
    private Map<String, String> body = new HashMap<>();
    List<Map<String, Object>> list = new ArrayList<>();

    private Observer<PushedFestivalRespData> showpushedfestival = new Observer<PushedFestivalRespData>() {
        @Override
        public void onNext(PushedFestivalRespData respData) {
            code = respData.code;
            pushedFestivals_list=respData.data;
            System.out.println(respData.data+"  qqqq--------------+++++++++++++++");
        }

        @Override
        public void onCompleted() {

            switch (code){
                case 200:
                    getView().showData(pushedFestivals_list);
                    getView().successRefresh();
                    getView().hideLoading();

                    break;

                case 404:
                    getView().showLoading();
                    getView().successRefresh();
                    break;
            }

            System.out.println("请求服务器成功");
        }

        @Override
        public void onError(Throwable e) {
            getView().hideLoading();
            getView().failedLink();
            getView().successRefresh();
            System.out.println(e.toString()+"服务器毛病---------------+++++++++++++++");
        }
    };

    public void request() {
        unsubscribe(subscription);
        subscription = NetWork.getUserService().showPushedFestival().subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(showpushedfestival);
    }



    protected void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}