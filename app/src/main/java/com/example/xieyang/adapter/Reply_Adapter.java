package com.example.xieyang.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.administrator.demo3.R;
import com.example.xieyang.entity.ReplyItemContent;
import com.example.xieyang.utils.GlideCircleTransform;
import com.example.xieyang.utils.ToSampleTime;

import java.util.List;

/**
 * Created by Administrator on 2016/7/10.
 */
public class Reply_Adapter extends BaseAdapter {

    private List<ReplyItemContent> data;
    private LayoutInflater layoutInflater;
    @SuppressWarnings("unused")
    private Context context = null;
    public ToSampleTime toSampleTime;

    private RequestManager glideRequest;

    public Reply_Adapter(Context context, List<ReplyItemContent> data) {
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public final class ReplyZujian {
        public TextView reply_name,reply_content,reply_time,reply_floor;
        public ImageView reply_headpicture;

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
    public View getView(int position, View convertView, ViewGroup parent) {

        ReplyZujian replyZujian = null;
        if (convertView == null) {
            replyZujian = new ReplyZujian();
            convertView = layoutInflater.inflate(R.layout.reply_listview, null);
            replyZujian.reply_name = (TextView) convertView.findViewById(R.id.reply_name);
            replyZujian.reply_content = (TextView) convertView.findViewById(R.id.reply_content);
            replyZujian.reply_time = (TextView) convertView.findViewById(R.id.reply_time);
            replyZujian.reply_floor = (TextView) convertView.findViewById(R.id.reply_floor);
            replyZujian.reply_headpicture = (ImageView) convertView.findViewById(R.id.reply_headpicture);
            convertView.setTag(replyZujian);
        } else {
            replyZujian = (ReplyZujian) convertView.getTag();
        }
        replyZujian.reply_name.setText(data.get(position).getReplyUserName());
        replyZujian.reply_content.setText(data.get(position).getReplyItemContent());
        replyZujian.reply_time.setText(toSampleTime.killMsec(data.get(position).getReplyUserTime()));
        replyZujian.reply_floor.setText(""+data.get(position).getReplyUserFloor()+"楼");//楼层
        glideRequest = Glide.with(context);
        if(data.get(position).getReplyUserHeadPicure()==null){
            glideRequest.load(R.drawable.img).transform(new GlideCircleTransform(context)).into(replyZujian.reply_headpicture);
        }else {
            glideRequest.load(data.get(position).getReplyUserHeadPicure()).transform(new GlideCircleTransform(context)).into(replyZujian.reply_headpicture);
        }
        return convertView;

    }

}
