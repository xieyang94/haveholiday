package com.example.xieyang.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.demo3.R;
import com.example.xieyang.utils.ToastView;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

public class BaseActivity<V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity<V,P> {

	private ToastView tostView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tostView=ToastView.createToastConfig();

	}

	@NonNull
	@Override
	public P createPresenter() {
		return null;
	}

	protected void showToast(String content){
		tostView.ToastShow(this,(ViewGroup) findViewById(R.id.toast_layout),content);
	}

	protected void showToastNative(String content){
		Toast.makeText(this,content, Toast.LENGTH_LONG).show();
	}



}
