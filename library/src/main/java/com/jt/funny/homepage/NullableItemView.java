package com.jt.funny.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jiangtao on 16/5/21.
 *
 * @author jiang.tao
 * @version 1.0.0
 */
public class NullableItemView implements ItemView {

    private Context mContext;

    /**
     * null item view
     *
     * @param context context
     */
    public NullableItemView(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(int position, View convertView, ViewGroup parent, LayoutInflater inflater, ItemVO vo) {
        return new View(mContext);
    }

    @Override
    public void onBindView(int position, View convertView, ViewGroup parent, ItemVO vo) {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }
}
