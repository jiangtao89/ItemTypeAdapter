package com.jt.funny.homepage.app.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

    public ItemViewImageView(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(int position, View convertView, ViewGroup parent, LayoutInflater inflater, com.jt.funny.homepage.ItemVO vo) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(R.drawable.ic_launcher);
        return imageView;
    }

    @Override
    public void onBindView(int position, View convertView, ViewGroup parent, com.jt.funny.homepage.ItemVO vo) {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    public static class ItemVO extends com.jt.funny.homepage.ItemVO {

        public ItemVO() {
            super(2, "image");
        }

        private int mId;

        public int getId() {
            return mId;
        }

        public void setId(int id) {
            mId = id;
        }
    }
}
