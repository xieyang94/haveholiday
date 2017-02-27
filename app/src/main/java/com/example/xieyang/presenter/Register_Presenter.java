package com.example.xieyang.presenter;

import com.example.xieyang.entity.User;
import com.example.xieyang.net.NetWork;
import com.example.xieyang.respmodule.RespDataStr;
import com.example.xieyang.utils.ShowLog;
import com.example.xieyang.view.Register_View;
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
public class Register_Presenter extends MvpBasePresenter<Register_View> {
    private int code;
    private User user;
    private String reStr;
    private Map<String,String> body=new HashMap<>();
    private Subscription subscription;

    private Observer<RespDataStr> register=new Observer<RespDataStr>(){
        @Override
        public void onNext(RespDataStr respDataStr) {
            code=respDataStr.code;
            reStr=respDataStr.data;
        }

        @Override
        public void onCompleted() {
            switch (code){
                case 200:
                    getView().hideLoading();
                    getView().registerSucess(code,reStr);
                    break;
                case 404:
                    getView().hideLoading();
                    getView().registerFailed();
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
     * 注册校验
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

    /**
     * 注册
     * 失败的可能性:
     * 0.邮箱输入格式错误
     * 1.邮箱被注册过
     * 2.没有输入密码（输入密码和再次输入密码为空）
     * 3.两次输入密码不一样
     * 4.邮箱、密码都没有输入
     * 5.没有输入邮箱
     *
     * 下面的校验方法为临时校验方法，需单独写个方法校验
     * @param email
     * @param pwd
     * @param pwd_again
     */
    public void register(String email,String pwd,String pwd_again) {
            if(validate(email,pwd,pwd_again)) {
            unsubscribe(subscription);
            body.clear();
            body.put("user.userEmail", email);
            body.put("user.userPassword", pwd);
            body.put("user.userPassword", pwd);
            subscription = NetWork.getUserService().userRegister(body).subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).subscribe(register);
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
        ShowLog.showTag("发送验证码=123=====" + email + codes);
        subscription1 = NetWork.getUserService().sendCode(body1).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(sendCode);

    }

    protected void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}