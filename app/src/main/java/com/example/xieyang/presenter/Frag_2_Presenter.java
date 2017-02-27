package com.example.xieyang.presenter;

import com.example.xieyang.entity.PictureDirect;
import com.example.xieyang.entity.PushedFestival;
import com.example.xieyang.net.NetWork;
import com.example.xieyang.respmodule.PictureDirectRespData;
import com.example.xieyang.respmodule.PushedFestivalRespData;
import com.example.xieyang.utils.ShowLog;
import com.example.xieyang.view.Frag_2_View;
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
public class Frag_2_Presenter extends MvpBasePresenter<Frag_2_View> {
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
                }

                @Override
                public void onCompleted() {

                        switch (code){
                                case 200:
                                        getView().success(pushedFestivals_list);

                                        break;

                                case 404:
                                        getView().success(pushedFestivals_list);
                                        break;
                        }

                        ShowLog.showTag("请求服务器成功");
                }

                @Override
                public void onError(Throwable e) {
                        getView().failedLink();
                        ShowLog.showTag(e.toString()+"服务器毛病---------------+++++++++++++++");
                }
        };

        public void request(String pushedfestivalnumber) {
                unsubscribe(subscription);
                body.clear();
                body.put("pushedFestivalnumber", pushedfestivalnumber);
                subscription = NetWork.getUserService().showonePushedFestival(body).subscribeOn(Schedulers.io()).
                        observeOn(AndroidSchedulers.mainThread()).subscribe(showpushedfestival);
        }



        protected Subscription subscription1;
        private int code1;
        private List<PictureDirect> pictureDirect_list;

        private Observer<PictureDirectRespData> showpushedfestival1 = new Observer<PictureDirectRespData>() {
                @Override
                public void onNext(PictureDirectRespData respData) {
                        code1 = respData.code;
                        pictureDirect_list=respData.data;
                }

                @Override
                public void onCompleted() {

                        switch (code1){
                                case 200:
                                        getView().success1(pictureDirect_list);

                                        break;

                                case 404:
                                        getView().success1(pictureDirect_list);
                                        break;
                        }

                        ShowLog.showTag("请求服务器成功");
                }

                @Override
                public void onError(Throwable e) {
                        getView().failedLink();
                        ShowLog.showTag(e.toString()+"服务器毛病---------------+++++++++++++++");
                }
        };

        public void request1() {
                unsubscribe(subscription1);
                subscription1 = NetWork.getUserService().pictureshow().subscribeOn(Schedulers.io()).
                        observeOn(AndroidSchedulers.mainThread()).subscribe(showpushedfestival1);
        }



        protected void unsubscribe(Subscription subscription) {
                if (subscription != null && !subscription.isUnsubscribed()) {
                        subscription.unsubscribe();
                }
        }



}
