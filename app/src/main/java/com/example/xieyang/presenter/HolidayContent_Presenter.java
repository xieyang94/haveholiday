package com.example.xieyang.presenter;

import com.example.xieyang.Config;
import com.example.xieyang.entity.Festival;
import com.example.xieyang.net.NetWork;
import com.example.xieyang.respmodule.FestivalRespData;
import com.example.xieyang.view.HolidayContent_View;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/7/24.
 */
public class HolidayContent_Presenter extends MvpBasePresenter<HolidayContent_View> {
    private int code;
    private Festival festivalfrom;
    private Map<String,String> body=new HashMap<>();
    private Subscription subscription;

    private Observer<FestivalRespData> showfestival=new Observer<FestivalRespData>(){
        @Override
        public void onNext(FestivalRespData respData) {
            code=respData.code;
            festivalfrom=respData.data;
            Config.FESTIVALGET=respData.data;
        }

        @Override
        public void onCompleted() {
            switch (code){
                case 200:
                    getView().getFestival(code, Config.FESTIVALGET);
                    getView().hideLoading();

                    break;

                case 404:
                    getView().showLoading();
                    break;
            }

            System.out.println("请求服务器成功");
        }

        @Override
        public void onError(Throwable e) {
            getView().hideLoading();
            getView().failedLink();
            System.out.println(e.toString() + "服务器请求失败或者服务器异常!!!--------HolidayContent_Presenter");

        }
    };


    public void showFestival(String festivalName,String festivalTime) {

        unsubscribe(subscription);
        body.clear();
        body.put("festival.festivalName",festivalName);
        body.put("festival.festivalTime", festivalTime);
        subscription = NetWork.getUserService().festivalShow(body).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(showfestival);
    }

    /**
     * 验证输入的名字不能为空
     * @param nickname
     * @return
     */
    public boolean verfication(String nickname){

        if ("".equals(nickname) || null == nickname)
            return false;

        return true;
    }

    protected void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
