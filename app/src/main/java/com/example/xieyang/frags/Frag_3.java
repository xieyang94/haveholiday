package com.example.xieyang.frags;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.demo3.R;
import com.example.xieyang.Config;
import com.example.xieyang.adapter.Squaqre_Adapter;
import com.example.xieyang.base.BaseFragment;
import com.example.xieyang.entity.PushedFestival;
import com.example.xieyang.presenter.Frag_3_Presenter;
import com.example.xieyang.utils.ShowLog;
import com.example.xieyang.view.Frag_3_View;

import java.util.ArrayList;
import java.util.List;
//

public class Frag_3 extends BaseFragment<Frag_3_View, Frag_3_Presenter> implements SwipeRefreshLayout.OnRefreshListener,Frag_3_View {
    private ListView list_square;
    private View view;
    private SwipeRefreshLayout mSwipeLayout;
    List<PushedFestival> pushedFestivals=new ArrayList<>();
    private Squaqre_Adapter squaqre_adapter;
    private ProgressDialog pd = null;


    private void init() {
        list_square = (ListView) view.findViewById(R.id.list_square);
        mSwipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.id_swipe_ly);
        mSwipeLayout.setOnRefreshListener(this);
        pd = new ProgressDialog(getActivity());
        pd.setMessage("正在加载……");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.menus_frag_square, null);
        init();
        pd.show();
        //设置下拉刷新转圈的颜色
        mSwipeLayout.setColorSchemeResources(R.color.red, R.color.black, R.color.geek_green, R.color.bg_grey);
        squaqre_adapter = new Squaqre_Adapter(getActivity(), pushedFestivals);
        list_square.setAdapter(squaqre_adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().request();
    }

    @Override
    public Frag_3_Presenter createPresenter() {
        return new Frag_3_Presenter();
    }

    @Override
    public void showData(List<PushedFestival> list_pushedFestival) {

        for (PushedFestival m:  list_pushedFestival) {
            pushedFestivals.add(m);
        }
        ShowLog.showTag("showData  "+list_pushedFestival.size()+" ----- "+pushedFestivals.size());
        squaqre_adapter.notifyDataSetChanged();
    }

    @Override
    public void successRefresh() {
        mSwipeLayout.setRefreshing(false);
        ShowLog.showTag("完成");
    }

    @Override
    public void showLoading() {
        pd.show();
    }

    @Override
    public void hideLoading() {
        pd.cancel();
    }

    @Override
    public void failedLink() {
        Toast.makeText(getActivity(), "连接不到服务器，或服务器异常", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        pushedFestivals.clear();
        getPresenter().request();

        Config.DOWNLIST=10;
    }
}