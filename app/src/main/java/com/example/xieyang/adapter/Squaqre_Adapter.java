package com.example.xieyang.adapter;

/**
 * Created by Administrator on 2016/7/3.
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.demo3.R;
import com.example.xieyang.aty.SquareContent_Activity;
import com.example.xieyang.entity.PushedFestival;
import com.example.xieyang.utils.ResultNull;
import com.example.xieyang.utils.ShowLog;

import java.util.List;

public class Squaqre_Adapter extends BaseAdapter {

    private List<PushedFestival> data;
    private LayoutInflater layoutInflater;
    private Context context = null;
    public ResultNull resultNull;

    public Squaqre_Adapter(Context context, List<PushedFestival> data) {
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }
    public final class Zujian {
        public TextView title;
        public LinearLayout square_layout;
        public LinearLayout square_layout_title;
        public ImageView square_image;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Zujian zujian = null;
        if (convertView == null) {
            zujian = new Zujian();
            convertView = layoutInflater.inflate(R.layout.square_listview, null);
            zujian.title = (TextView) convertView.findViewById(R.id.square_title);
            zujian.square_image = (ImageView) convertView.findViewById(R.id.square_image);
            zujian.square_layout = (LinearLayout) convertView.findViewById(R.id.square_layout);
            convertView.setTag(zujian);
        } else {
            zujian = (Zujian) convertView.getTag();
        }
        zujian.title.setText( data.get(position).getPushedFestivalTitle());

        String internetUrl =data.get(position).getPushedFestivalItemPicture();

        Glide
                .with(context)
                .load(internetUrl)
                .centerCrop()//CenterCrop()是一个裁剪技术，即缩放图像让它填充到 ImageView 界限内并且侧键额外的部分
                .crossFade()//淡入淡出
//                .error(R.mipmap.error)//加载失败时，显示默认图片
                .into(zujian.square_image);
        ShowLog.showTag("1234567============");
        zujian.square_layout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SquareContent_Activity.class);
                intent.putExtra("push_festival_ID",""+data.get(position).getPushedFestivalId());//把推送条目的ID传过去
                intent.putExtra("pushed_festival_ContentBg",""+data.get(position).getPushedFestivalContentBg());
                intent.putExtra("pushed_festival_Content_Title",""+resultNull.solveNull(data.get(position).getPushedFestivalContentTitle()));
                intent.putExtra("pushed_festival_Content",""+resultNull.solveNull(data.get(position).getPushedFestivalContent()));
                intent.putExtra("pushed_festival_Content2","" +resultNull.solveNull(data.get(position).getPushedFestivalContent2()));
                intent.putExtra("pushed_festival_Content3","" +resultNull.solveNull(data.get(position).getPushedFestivalContent3()));
                intent.putExtra("pushed_festival_Content4","" +resultNull.solveNull(data.get(position).getPushedFestivalContent4()));
                intent.putExtra("pushed_festival_Content5","" +resultNull.solveNull(data.get(position).getPushedFestivalContent5()));
                intent.putExtra("pushed_festival_Content6","" +resultNull.solveNull(data.get(position).getPushedFestivalContent6()));
                intent.putExtra("pushed_festival_Content7","" +resultNull.solveNull(data.get(position).getPushedFestivalContent7()));
                intent.putExtra("reply_ID",""+data.get(position).getReplyID());
                intent.putExtra("reply_Count",""+data.get(position).getReplyCount());
                intent.putExtra("like_State",""+data.get(position).getLikeState());
                intent.putExtra("like_Count",""+data.get(position).getLikeCount());
                intent.putExtra("push_festival_Time",""+data.get(position).getPushFestivalTime());
                context.startActivity(intent);
            }
        });
        return convertView;

    }

}
