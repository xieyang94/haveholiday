package com.example.xieyang.view;

import com.example.xieyang.entity.PictureDirect;
import com.example.xieyang.entity.PushedFestival;
import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/7/23.
 */
public interface Frag_2_View extends MvpView {
    void success(List<PushedFestival> pushedFestivals);
    void success1(List<PictureDirect> pictureDirects);
    void failedLink();
}
