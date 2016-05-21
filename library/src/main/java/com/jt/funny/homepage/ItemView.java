package com.jt.funny.homepage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jiangtao on 16/5/21.
 *
 * @author jiang.tao
 * @version 1.0.0
 */
public interface ItemView<T extends BaseItemVO> {

    /**
     * list view create view
     *
     * @param position    position
     * @param convertView convertView
     * @param parent      parent
     * @param vo          vo
     * @return view
     */
    public View onCreateView(int position, View convertView, ViewGroup parent, LayoutInflater inflater, T vo);

    /**
     * list view bind vo
     *
     * @param position    position
     * @param vo          vo
     */
    public void onBindView(int position, View convertView, ViewGroup parent, T vo);

    public void onPause();

    public void onResume();
}
