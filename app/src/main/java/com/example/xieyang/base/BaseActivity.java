package com.example.xieyang.base;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

public class BaseActivity<V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity<V,P> {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@NonNull
	@Override
	public P createPresenter() {
		return null;
	}



}
