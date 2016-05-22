package com.jt.funny.homepage.app.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;
import com.jt.funny.homepage.ItemView;

/**
 * Created by jiangtao on 16/5/21.
 *
 * @author jiang.tao
 * @version 1.0.0
 */
public class ItemViewTextView implements ItemView {

    private Context mContext;
    private TextView mTextView;

    public ItemViewTextView(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(int position, View convertView, ViewGroup parent, LayoutInflater inflater, com.jt.funny.homepage.ItemVO vo) {
        mTextView = new TextView(mContext);
        return mTextView;
    }

    @Override
    public void onBindView(int position, View convertView, ViewGroup parent, com.jt.funny.homepage.ItemVO vo) {
        mTextView.setText(((ItemVO)vo).getTitle());
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    public static class ItemVO extends com.jt.funny.homepage.ItemVO {

        @SerializedName("title")
        private String mTitle = "";

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(String title) {
            mTitle = title;
        }
    }
}
