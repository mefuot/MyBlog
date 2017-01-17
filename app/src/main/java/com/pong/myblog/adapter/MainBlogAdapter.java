package com.pong.myblog.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pong.myblog.R;
import com.pong.myblog.model.BlogModel;

import java.util.List;

/**
 * Created by USER on 17/1/2560.
 */

public class MainBlogAdapter extends BaseAdapter {
    private List<BlogModel> list;
    private LayoutInflater inflater;

    public MainBlogAdapter(Context context, List<BlogModel> list) {
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return (list!=null)?list.size():0;
    }

    @Override
    public BlogModel getItem(int position) {
        return (list!=null)?list.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void updateBlogList(List<BlogModel> newList){
        this.list = newList;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.view_blog_item,null);

            holder.titleView = (TextView) convertView.findViewById(R.id.textview_blogitem_title);
            holder.dateView = (TextView) convertView.findViewById(R.id.textview_blogitem_date);
            holder.contentView = (WebView) convertView.findViewById(R.id.webview_blogitem_content);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        setupViewHolderData(holder,position);

        return convertView;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupViewHolderData(final ViewHolder holder, final int position){
        if(getItem(position) != null) {
            holder.titleView.setText(getItem(position).getTitle());
            holder.dateView.setText(getItem(position).getDate());
            holder.contentView.getSettings().setJavaScriptEnabled(true);
            holder.contentView.loadData(getItem(position).getContent(), "text/html; charset=utf-8", "UTF-8");
        }else{
            holder.titleView.setText("title is null");
            holder.dateView.setText("date is null");
        }
    }

    private static class ViewHolder{
        TextView titleView;
        TextView dateView;
        WebView contentView;
    }
}
