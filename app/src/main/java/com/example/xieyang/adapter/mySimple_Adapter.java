package com.example.xieyang.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.demo3.R;
import com.example.xieyang.Config;
import com.example.xieyang.aty.SumHoliday_Activity;
import com.example.xieyang.frags.Frag_home;
import com.example.xieyang.utils.GetHolidayName;
import com.example.xieyang.utils.Lunar;
import com.example.xieyang.utils.Solar;
import com.example.xieyang.utils._24SolarTerms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class mySimple_Adapter extends BaseAdapter {
    // private String day1[]= null;
    private int day;
    private int month;
    private int month_holiday;
    private int year;
    private String every_day;//每天对应的阳历
    private String every_month;//每月对应的日历
    private String every_day_lunar;//每天对应的阴历
    private StringBuffer solarTerm=new StringBuffer();//获取当前页面的二十四节气
    private StringBuffer lunar_holiday=new StringBuffer();//获取当前页面的阴历节日
    private StringBuffer lunar_chuxi=new StringBuffer();//获取除夕
    @SuppressWarnings("unused")
    private Context context = null;
    private LayoutInflater inflater = null;
    public Frag_home mainActivity;
    public static Solar solar;
    public GetHolidayName getHolidayName = new GetHolidayName();
    private int count2 = 0;
    private static final int count3 = 1;
    private static int n = 42;
    public Lunar lunar;
    public _24SolarTerms _24solarTerms;
    private String lmonth = "";
    private String lday = "";
    private String[] str4 = {"闰一月", "闰二月", "闰三月", "闰四月", "闰五月", "闰六月", "闰七月",
            "闰八月", "闰九月", "闰十月", "闰十一月", "闰十二月", "一月", "二月", "三月", "四月", "五月",
            "六月", "七月", "八月", "九月", "十月", "十一月", "十二月", "初一", "初二", "初三", "初四",
            "初五", "初六", "初七", "初八", "初九", "初十", "十一", "十二", "十三", "十四", "十五",
            "十六", "十七", "十八", "十九", "廿十", "廿一", "廿二", "廿三", "廿四", "廿五", "廿六",
            "廿七", "廿八", "廿九", "卅十"};
    public static SimpleDateFormat chineseDateFormat = new SimpleDateFormat("yyyy年MM月dd日");


    public mySimple_Adapter() {
    }


    public mySimple_Adapter(Context context, int day, int month, int year) {
        super();
        this.day = day;
        this.month = month;
        this.year = year;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
//        int m = solar.getWeek(year, month) - 1 + solar.setDayCount(year, month);
        return 49;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class Holder {

        public TextView tv;
        public TextView tv1;
        public ImageView image1;
        public LinearLayout layout;
        public boolean ishave = false;

        public boolean isHave() {
            return ishave;
        }

    }



    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder;
        if (convertView == null) {

            convertView = inflater.inflate(R.layout.day, null);
            holder = new Holder();
            holder.tv = (TextView) convertView.findViewById(R.id.tv);
            holder.tv1 = (TextView) convertView.findViewById(R.id.tv1);
            holder.image1 = (ImageView) convertView.findViewById(R.id.image1);
            holder.layout = (LinearLayout) convertView.findViewById(R.id.layout_day);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        int week = solar.getWeek(year, month) - 1;//国际的星期是日、一、二、三、四、五、六，对应的1,2,3,4,5,6,7
        if (position < week) {

            /**
             * 1.获取上一个月的天数 2.获取对应天数的日期
             */
            month_holiday = month - 1;
            holder.tv.setText("");
        } else if (position < solar.setDayCount(year, month) + week) {
            month_holiday = month;
            int i = position + 1 - week;
            every_month = "" + month;
            every_day = "" + i;
            holder.tv.setText("" + i);
            String str = "" + year + "年" + month + "月" + i + "日";
//            System.out.println(str);
            Calendar today = Calendar.getInstance();
            try {
                today.setTime(chineseDateFormat.parse(str));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            lunar = new Lunar(today);
            every_day_lunar = "" + lunar;
            if (getHolidayName.getHoliday(year,month, i).equals("")) {
                holder.tv1.setText("" + lunar);
            } else {
                String a[] = getHolidayName.getHoliday(year,month, i).split(",");
                holder.tv1.setText(a[0]);

                holder.ishave = true;
            }

            /**
             * 24节气
             */
            String sol = _24solarTerms.solarTermToString(year, month, i);
            if (sol.equals("")) {
            } else {
                holder.tv1.setText(sol);
                holder.ishave = true;
                holder.tv1.setTextColor(Color.CYAN);
                String solarstr=""+sol+"        "+month+"月"+i+"日";
                solarTerm.append(solarstr);
                solarTerm.append(",");
//                System.out.println(""+sol+month+"月"+i+"日"+"24节气");
                System.out.println(""+solarTerm+"24节气");
            }
//            solarTerm.substring(0,solarTerm.length()-1);

            //阴历中的节日
            // 农历月、日(天数)
            lmonth = Lunar.chineseNumber[lunar.getMonth1() - 1];
            lday = Lunar.getChinaDayString(lunar.getDay1());
            lunar_holiday.append(lmonth+"月"+lday+",");
//            System.out.println("----------农历月-------" + lmonth + "农历日" + lday + "---------");
            // 确定除夕
            int dayofchuxi = Lunar.monthDays(lunar.getYear1(), lunar.getMonth1());
            String str1 = "";
            if (dayofchuxi == 29) {
                str1 = "廿九";
            } else if (dayofchuxi == 30) {
                str1 = "卅十";
            }
            if (lmonth.equals("十二") && lday.equals(str1)) {
                holder.tv1.setText("除夕");
                holder.ishave = true;
                holder.tv1.setTextColor(Color.CYAN);
                lunar_chuxi.append(lmonth + "月" + str1);
//                System.out.println(lmonth + "月" + str1+"除夕--------------------------");
            }
            //阴历节日
            if (getHolidayName.getLunarHoliday(lmonth, lday,"","").equals("")) {
            } else {
                String a[] = getHolidayName.getLunarHoliday(lmonth, lday,"","").split(",");
                holder.tv1.setText(a[0]);
                holder.ishave = true;
                holder.tv1.setTextColor(Color.CYAN);
            }

            //节日标签
            for (String str3 : str4) {
                if (holder.ishave == true) {
                    holder.tv.setTextColor(Color.CYAN);
                    holder.tv1.setTextColor(Color.CYAN);
                }
            }
        }
        //GridView的Item设置为可点击
        holder.layout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String str=holder.tv.getText().toString();
                String str1=holder.tv1.getText().toString();
                if (holder.isHave() == true) {
                    Intent intent = new Intent(context, SumHoliday_Activity.class);
//					intent.putExtra("name",""+lmonth+"月"+lday+"日"+"阳历"+every_day);
//                    System.out.println("" + lmonth + "月" + lday + "日" + "阳历" + every_day+"阳历"+str+"阴历"+str1);

                    intent.putExtra("month", "" + every_month);
                    intent.putExtra("year", "" + year);
                    intent.putExtra("dayCount", "" + every_day);
                    intent.putExtra("lunarmonth", "" + lmonth);
                    intent.putExtra("lunarlastday", "" + lday);
                    intent.putExtra("solarTerm", "" + solarTerm);
                    intent.putExtra("lunar_holiday", "" + lunar_holiday);
                    intent.putExtra("lunar_chuxi", "" + lunar_chuxi);
                    context.startActivity(intent);
                }
            }
        });


        //今天，获取当前日期，并标志为蓝色
        int j = solar.StrToInt(solar.nowDay()) - 1;//为什么要-1，真烦，自己忘了
        if (j == (position - week)
                && year == solar.StrToInt(solar.nowYear())
                && month == solar.StrToInt(solar.nowMonth())) {
            // holder.layout.setBackgroundColor(Color.CYAN);
//            System.out.println("------------------------------------------------------------------当前天"+j);
            holder.tv.setTextColor(Color.BLUE);
            holder.tv1.setTextColor(Color.BLUE);
            Config.HOLDER=holder.ishave;
        }
        /**
         * 发节日通告
         */
        //时间,早上七点半
        Config.YEAR=year;
        Config.MONTH=month;
        Config.DAY=j+1;
//        Intent intentservice=new Intent(context, NotifyService.class);
//        context.startService(intentservice);

        return convertView;
    }


}