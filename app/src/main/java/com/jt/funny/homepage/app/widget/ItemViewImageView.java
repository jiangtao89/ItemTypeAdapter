package com.jt.funny.homepage.app.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;
import com.jt.funny.homepage.ItemView;
import com.jt.funny.homepage.app.R;

/**
 * Created by jiangtao on 16/5/21.
 *
 * @author jiang.tao
 * @version 1.0.0
 */
public class ItemViewImageView implements ItemView {

    private Context mContext;
    private ImageView mImageView;

    public ItemViewImageView(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(int position, View convertView, ViewGroup parent, LayoutInflater inflater, com.jt.funny.homepage.ItemVO vo) {
        FrameLayout frameLayout = new FrameLayout(mContext);
        mImageView = new ImageView(mContext);
        frameLayout.addView(mImageView);
        return frameLayout;
    }

    @Override
    public void onBindView(int position, View convertView, ViewGroup parent, com.jt.funny.homepage.ItemVO vo) {
        Glide.with(mContext)
                .load(((ItemVO)vo).getUrl())
                .placeholder(R.drawable.ic_launcher)
                .into(mImageView);
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    public static class ItemVO extends com.jt.funny.homepage.ItemVO {

        @SerializedName("url")
        private String mUrl = "";

        public String getUrl() {
            return mUrl;
        }

        public void setUrl(String url) {
            mUrl = url;
        }
    }
}
