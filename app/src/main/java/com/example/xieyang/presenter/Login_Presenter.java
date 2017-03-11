package com.example.xieyang.presenter;

import com.example.xieyang.Config;
import com.example.xieyang.entity.User;
import com.example.xieyang.net.NetWork;
import com.example.xieyang.respmodule.RespData;
import com.example.xieyang.utils.ShowLog;
import com.example.xieyang.view.Login_View;
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
public class Login_Presenter extends MvpBasePresenter<Login_View>{
    protected Subscription subscription;
    private  int code ;
    private User fromServer;
    private Map<String, String> body = new HashMap<>();
    private String reStr;

    private Observer<RespData> login= new Observer<RespData>() {
        @Override
        public void onNext(RespData respData) {
            code = respData.code;
            fromServer = respData.data;
            Config.USERGET = respData.data;
            ShowLog.showTag(code+"----------------------------------code'"+Config.USERGET.getToken());
        }
        @Override
        public void onCompleted() {
            switch (code){
                case 200:
                    getView().cplLogin(code, fromServer);
                    getView().successLogin();
                    getView().hideLoading();
                    break;
                case 404:
                    getView().fLogin();
                    getView().hideLoading();
                    ShowLog.showTag("222222222222222222222222222222222    404");
                    break;
            }

        }
        @Override
        public void onError(Throwable e) {
            getView().hideLoading();
            getView().failedLink();

            ShowLog.showTag(e.toString() + "服务器请求失败或者服务器异常!!!--------Login_Presenter"+"code"+code);
        }
    };


    public void login(String id,String pwd) {
        if (id.equals("")||id==null){
            getView().nullId();
            getView().hideLoading();
            return;
        }else if(pwd.equals("")||pwd==null){
            getView().nullPwd();
            getView().hideLoading();
            return;
        }
        unsubscribe(subscription);
        body.clear();
        body.put("user.userEmail", id);
        body.put("user.userPassword", pwd);
        subscription = NetWork.getUserService().userLogin(body).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(login);

    }


    protected void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }


}
