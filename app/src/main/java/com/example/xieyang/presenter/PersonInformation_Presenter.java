package com.example.xieyang.presenter;

import com.example.xieyang.Config;
import com.example.xieyang.entity.User;
import com.example.xieyang.net.NetWork;
import com.example.xieyang.respmodule.RespData;
import com.example.xieyang.utils.ShowLog;
import com.example.xieyang.view.PersonInformation_View;
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
public class PersonInformation_Presenter extends MvpBasePresenter<PersonInformation_View>{

    private int code;
    private User userfrom;
    private String reStr;
    private Map<String,String> body=new HashMap<>();
    private Subscription subscription;

    private Observer<RespData> update=new Observer<RespData>(){
        @Override
        public void onNext(RespData respData) {
            code=respData.code;
            userfrom=respData.data;
            Config.USERGET=respData.data;
        }

        @Override
        public void onCompleted() {
            switch (code){
                case 200:
                    getView().hideLoading();
                    getView().successUpdate();
                    break;

                case 404:
                    getView().hideLoading();
                    getView().twoUser();
                    break;
            }

        }

        @Override
        public void onError(Throwable e) {
            getView().hideLoading();
            getView().failedLink();
            ShowLog.showTag(e.toString() + "服务器请求失败或者服务器异常!!!--------PersonInformation_Presenter");

        }
    };


    public void save(String email,String name,String sex,String birthday,String constellation,String token) {

            unsubscribe(subscription);
            body.clear();
            body.put("user.userEmail",email);
            body.put("user.userName", name);
            body.put("user.userSex", sex);
            body.put("user.userBirthday", birthday);
            body.put("user.userConstellation", constellation);
            body.put("user.token", token);
            subscription = NetWork.getUserService().userUpdate(body).subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).subscribe(update);
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
