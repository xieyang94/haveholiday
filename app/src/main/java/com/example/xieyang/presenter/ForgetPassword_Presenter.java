package com.example.xieyang.presenter;

import com.example.xieyang.net.NetWork;
import com.example.xieyang.respmodule.RespDataStr;
import com.example.xieyang.view.ForgetPassword_View;
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
public class ForgetPassword_Presenter extends MvpBasePresenter<ForgetPassword_View> {
    private int code;
    private String reStr;
    private Map<String,String> body=new HashMap<>();
    private Subscription subscription;

    private Observer<RespDataStr> forgetPwd=new Observer<RespDataStr>(){
        @Override
        public void onNext(RespDataStr respData) {
            code=respData.code;
            reStr=respData.data;
        }

        @Override
        public void onCompleted() {
            switch (code){
                case 200:
                    getView().hideLoading();
                    getView().successforget();
                    break;
                case 404:
                    getView().hideLoading();
                    getView().failedforget();
                    break;
            }
        }

        @Override
        public void onError(Throwable e) {
            getView().hideLoading();
            getView().failedLink();
        }
    };

    /**
     * 校验
     * @return
     */
    public boolean validate(String email,String pwd,String pwd_again){
        if(email.equals("")||pwd.equals("")||pwd_again.equals("")){
            getView().nullValue();
            return false;
        }else if (!email.matches("\\w+@\\w+\\.\\w+")) {
            getView().failedEmail();
            return false;
        }else if(pwd.length()<6||pwd.length()>10){
            getView().failedPasswordLength();
            return false;
        }else if(!pwd.equals(pwd_again)){
            getView().notSamePwd();
            return false;
        }
        return true;
    }

    public void forgetPwd(String email,String pwd,String pwd_again) {
        if(validate(email,pwd,pwd_again)) {
            unsubscribe(subscription);
            body.clear();
            body.put("user.userEmail", email);
            body.put("user.userPassword", pwd);
            body.put("user.userPassword", pwd);
            subscription = NetWork.getUserService().forgetPwd(body).subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).subscribe(forgetPwd);
        }

    }

    /**
     * 发送验证码
     * @param subscription
     */
    protected Subscription subscription1;
    private  int code1 ;
    private Map<String, String> body1 = new HashMap<>();
    private String reStr1;

    private Observer<RespDataStr> sendCode= new Observer<RespDataStr>() {
        @Override
        public void onNext(RespDataStr respData) {
            code1 = respData.code;
            reStr1 = respData.data;
        }
        @Override
        public void onCompleted() {
            switch (code1){
                case 200:
                    getView().hideLoading();
                    getView().successcode();
                    break;
                case 404:
                    getView().hideLoading();
                    getView().failedcode();
                    break;
            }
        }
        @Override
        public void onError(Throwable e) {
            getView().hideLoading();
            getView().failedLink();
        }
    };

    public void sendCode(String email,String codes) {
        unsubscribe(subscription1);
        body1.clear();
        body1.put("emails", email);
        body1.put("codes", codes);
        subscription1 = NetWork.getUserService().sendCode(body1).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(sendCode);

    }

    protected void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
