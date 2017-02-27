package com.example.xieyang.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.administrator.demo3.R;
import com.example.xieyang.adapter.mySimple_Adapter;
import com.example.xieyang.base.BaseFragment;
import com.example.xieyang.presenter.Frag_home_Presenter;
import com.example.xieyang.utils.ShowLog;
import com.example.xieyang.utils.Solar;
import com.example.xieyang.view.Frag_home_View;

public class Frag_home extends BaseFragment<Frag_home_View, Frag_home_Presenter> {

    private View view;
    private static GridView gv;
    private TextView text, button_today;
    private static int year, today_year;
    private static int month, today_month;
    private static int day, today_day;
    private static int count = 1;
    private static int count1 = 1;
    public static Solar solar;
    private static mySimple_Adapter adapter;
//    private static Context contextL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.menus_frag_day, null);
        gv = (GridView) view.findViewById(R.id.gv);
        text = (TextView) view.findViewById(R.id.text);
        ShowLog.showTag(solar.getWeek(2016, 5) + "----------------------------------");
        day = solar.setDayCount(solar.StrToInt(solar.nowYear()), solar.StrToInt(solar.nowMonth()));
        month = solar.StrToInt(solar.nowMonth());
        year = solar.StrToInt(solar.nowYear());
        text.setText("" + year + "/" + month + "");
        adapter = new mySimple_Adapter(getActivity(), day, month, year);
        gv.setAdapter(adapter);
        today_year = year;
        today_month = month;
        today_day = day;


        view.findViewById(R.id.btn_up_month).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                month = (month + count) % 12;
                ShowLog.showTag(month + "------------------分割线up----------------");
                if (month == 0) {
                    month = 12;
                }
                if (month == 1) {
                    year += 1;
                }
                day = solar.setDayCount(year, month);
                adapter = new mySimple_Adapter(getActivity(), day, month, year);
                gv.setAdapter(adapter);
                text.setText("" + year + "年" + month + "月");
            }
        });
        view.findViewById(R.id.btn_down_month).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                month = (month - count1) % 12;
                ShowLog.showTag(month + "------------------分割线down----------------");
                if (month == 0) {
                    month = 12;
                }
                if (month == 12) {
                    year -= 1;
                }
                day = solar.setDayCount(year, month);
                adapter = new mySimple_Adapter(getActivity(), day, month, year);
                gv.setAdapter(adapter);
                text.setText("" + year + "年" + month + "月");
            }
        });
        view.findViewById(R.id.button_today).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter = new mySimple_Adapter(getActivity(), today_day, today_month, today_year);
                gv.setAdapter(adapter);
                text.setText("" + today_year + "年" + today_month + "月");
                day = today_day;
                month = today_month;
                year = today_year;
            }
        });
        return view;
    }


    @Override
    public Frag_home_Presenter createPresenter() {
        return new Frag_home_Presenter();
    }

    /**
     * 广播，唤醒adapter
     */
//    public static class CallAdapterReceiver extends BroadcastReceiver {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            day = solar.setDayCount(solar.StrToInt(solar.nowYear()), solar.StrToInt(solar.nowMonth()));
//            month = solar.StrToInt(solar.nowMonth());
//            year = solar.StrToInt(solar.nowYear());
//            ShowLog.showTag(day+"--"+month+"--"+year);
//            adapter = new mySimple_Adapter(contextL, day, month, year);
//            gv.setAdapter(adapter);
//        }
//    }
}