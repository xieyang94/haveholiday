package com.example.xieyang.presenter;

import android.content.Context;
import android.net.Uri;

import com.example.xieyang.Config;
import com.example.xieyang.net.NetWork;
import com.example.xieyang.respmodule.RespDataStr;
import com.example.xieyang.utils.ShowLog;
import com.example.xieyang.utils.UriTopath;
import com.example.xieyang.view.MainActivity_View;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MainActivity_Presenter extends MvpBasePresenter<MainActivity_View> {
    /**
     * 上传头像
     */
    private int code;
    private String reStr;
    private Subscription subscription;

    private UriTopath uriTopath;

    private Observer<RespDataStr> update=new Observer<RespDataStr>(){
        @Override
        public void onNext(RespDataStr respData) {
            code=respData.code;
            reStr=respData.data;
            Config.headPicturecode=code;
        }

        @Override
        public void onCompleted() {
            switch (code){
                case 200:
                    getView().successChangeHeadPicture(reStr);
                    ShowLog.showTag("头像上传成功!!!");
                    break;
                case 404:
                    getView().twoUser(code);
                    ShowLog.showTag("您的账号已在别的设备登录，请您重新登录!!!");
                    break;
            }
            ShowLog.showTag("请求服务器成功,更改头像成功--------------------------");
        }

        @Override
        public void onError(Throwable e) {
            ShowLog.showTag(e.toString() + "服务器请求失败或者服务器异常!!!--------MainActivity_Presenter");
        }
    };

    public void updateHeadPicture( Uri uritopathStr,Context context,String email,String token) {
        unsubscribe(subscription);

        File file = new File(uriTopath.getImageAbsolutePath(context, uritopathStr));
        RequestBody photoRequestBody = RequestBody.create(MediaType.parse(uriTopath.getMimeType(file.getAbsolutePath())), file);
        MultipartBody.Part file1= MultipartBody.Part.createFormData("file1",file.getName(), photoRequestBody);

        subscription = NetWork.getUserService().updateUserHeadPicture(file1, RequestBody.create(null,email), RequestBody.create(null,token)).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(update);
    }

    protected void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
