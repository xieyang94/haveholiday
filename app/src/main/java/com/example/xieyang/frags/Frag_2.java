package com.example.xieyang.frags;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.demo3.R;
import com.example.xieyang.aty.SquareContent_Activity;
import com.example.xieyang.aty.SumHoliday_month_Activity;
import com.example.xieyang.common.BaseFragment;
import com.example.xieyang.entity.PictureDirect;
import com.example.xieyang.entity.PushedFestival;
import com.example.xieyang.presenter.Frag_2_Presenter;
import com.example.xieyang.utils.ResultNull;
import com.example.xieyang.view.Frag_2_View;
import com.example.xieyang.viewpager.MyPagerGalleryView;

import java.util.List;


public class Frag_2 extends BaseFragment<Frag_2_View, Frag_2_Presenter> implements View.OnClickListener,Frag_2_View {

    private Context context;
    private LinearLayout ovalLayout;
    private TextView adgallerytxt;
    private MyPagerGalleryView galleryView;
    private ResultNull resultNull;

    private TextView month_January, month_February, month_March, month_April,
            month_May, month_June, month_July, month_August, month_September,
            month_October, month_November, month_December;

    private View view;
    private String[] mUris = new String[3];
    private String[] imgTexts = new String[3];

    private void onClickL() {
        month_January.setOnClickListener(this);
        month_February.setOnClickListener(this);
        month_March.setOnClickListener(this);
        month_April.setOnClickListener(this);
        month_May.setOnClickListener(this);
        month_June.setOnClickListener(this);
        month_July.setOnClickListener(this);
        month_August.setOnClickListener(this);
        month_September.setOnClickListener(this);
        month_October.setOnClickListener(this);
        month_November.setOnClickListener(this);
        month_December.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.menus_frag_month, null);
        init();
//        initGalleryView();

        onClickL();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().request1();
    }


    @SuppressLint("NewApi")
    private void init() {
        month_January = (TextView) view.findViewById(R.id.month_January);
        month_February = (TextView) view.findViewById(R.id.month_February);
        month_March = (TextView) view.findViewById(R.id.month_March);
        month_April = (TextView) view.findViewById(R.id.month_April);
        month_May = (TextView) view.findViewById(R.id.month_May);
        month_June = (TextView) view.findViewById(R.id.month_June);
        month_July = (TextView) view.findViewById(R.id.month_July);
        month_August = (TextView) view.findViewById(R.id.month_August);
        month_September = (TextView) view.findViewById(R.id.month_September);
        month_October = (TextView) view.findViewById(R.id.month_October);
        month_November = (TextView) view.findViewById(R.id.month_November);
        month_December = (TextView) view.findViewById(R.id.month_December);
        ovalLayout = (LinearLayout) view.findViewById(R.id.ovalLayout1);
        adgallerytxt = (TextView) view.findViewById(R.id.adgallerytxt);
        galleryView = (MyPagerGalleryView) view.findViewById(R.id.gallerview);

    }

    //初始化轮播图片
    private void initGalleryView() {
        galleryView.start(getActivity(), mUris, null, 3000, ovalLayout,
                R.drawable.icon_point_pre,
                R.drawable.icon_point, adgallerytxt, imgTexts);
        galleryView.setMyOnItemClickListener(new MyPagerGalleryView.MyOnItemClickListener() {

            @Override
            public void onItemClick(int curIndex) {
                getPresenter().request(imgTexts[curIndex]);
//                if (imgHrefs[curIndex] != null && !imgHrefs[curIndex].isEmpty()) {
//                    MyNetUtils.turnToMyWebViewer(context, imgHrefs[curIndex]); // 用内部浏览器打开
//                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.month_January:
                sendHolidaylist(1);
                break;
            case R.id.month_February:
                sendHolidaylist(2);
                break;
            case R.id.month_March:
                sendHolidaylist(3);
                break;
            case R.id.month_April:
                sendHolidaylist(4);
                break;
            case R.id.month_May:
                sendHolidaylist(5);
                break;
            case R.id.month_June:
                sendHolidaylist(6);
                break;
            case R.id.month_July:
                sendHolidaylist(7);
                break;
            case R.id.month_August:
                sendHolidaylist(8);
                break;
            case R.id.month_September:
                sendHolidaylist(9);
                break;
            case R.id.month_October:
                sendHolidaylist(10);
                break;
            case R.id.month_November:
                sendHolidaylist(11);
                break;
            case R.id.month_December:
                sendHolidaylist(12);
                break;
        }
    }

    //月份对应的节日列表跳转
    public void sendHolidaylist(int month) {
        Intent intent = new Intent(getActivity(), SumHoliday_month_Activity.class);
        intent.putExtra("now_month", "" + month);
        startActivity(intent);
    }

    @Override
    public void success(List<PushedFestival> pushedFestivalslist) {
        Intent intent = new Intent(getActivity(), SquareContent_Activity.class);
        intent.putExtra("push_festival_ID",""+pushedFestivalslist.get(0).getPushedFestivalId());//把推送条目的ID传过去
        intent.putExtra("pushed_festival_ContentBg",""+pushedFestivalslist.get(0).getPushedFestivalContentBg());
        intent.putExtra("pushed_festival_Content_Title",""+resultNull.solveNull(pushedFestivalslist.get(0).getPushedFestivalContentTitle()));
        intent.putExtra("pushed_festival_Content",""+resultNull.solveNull(pushedFestivalslist.get(0).getPushedFestivalContent()));
        intent.putExtra("pushed_festival_Content2","" +resultNull.solveNull(pushedFestivalslist.get(0).getPushedFestivalContent2()));
        intent.putExtra("pushed_festival_Content3","" +resultNull.solveNull(pushedFestivalslist.get(0).getPushedFestivalContent3()));
        intent.putExtra("pushed_festival_Content4","" +resultNull.solveNull(pushedFestivalslist.get(0).getPushedFestivalContent4()));
        intent.putExtra("pushed_festival_Content5","" +resultNull.solveNull(pushedFestivalslist.get(0).getPushedFestivalContent5()));
        intent.putExtra("pushed_festival_Content6","" +resultNull.solveNull(pushedFestivalslist.get(0).getPushedFestivalContent6()));
        intent.putExtra("pushed_festival_Content7","" +resultNull.solveNull(pushedFestivalslist.get(0).getPushedFestivalContent7()));
        intent.putExtra("reply_ID",""+pushedFestivalslist.get(0).getReplyID());
        intent.putExtra("reply_Count",""+pushedFestivalslist.get(0).getReplyCount());
        intent.putExtra("like_State",""+pushedFestivalslist.get(0).getLikeState());
        intent.putExtra("like_Count",""+pushedFestivalslist.get(0).getLikeCount());
        intent.putExtra("push_festival_Time",""+pushedFestivalslist.get(0).getPushFestivalTime());
        startActivity(intent);
    }

    @Override
    public void success1(List<PictureDirect> pictureDirects) {
        for (int i = 0; i < 3; i++) {
            imgTexts[i]=pictureDirects.get(i).getPictureNumber();
            mUris[i]=pictureDirects.get(i).getPictureUrl();
        }
        initGalleryView();
    }

    @Override
    public void failedLink() {
        Toast.makeText(getActivity(), "连接失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Frag_2_Presenter createPresenter() {
        return new Frag_2_Presenter();
    }
}
