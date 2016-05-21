package com.jt.funny.homepage.app.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jt.funny.homepage.BaseItemVO;
import com.jt.funny.homepage.ItemView;

/**
 * Created by jiangtao on 16/5/21.
 *
 * @author jiang.tao
 * @version 1.0.0
 */
public class ItemViewTextView implements ItemView {

    private Context mContext;

    public ItemViewTextView(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(int position, View convertView, ViewGroup parent, LayoutInflater inflater, BaseItemVO vo) {
        TextView textView = new TextView(mContext);
        textView.setText("item view text view");
        return textView;
    }

    @Override
    public void onBindView(int position, View convertView, ViewGroup parent, BaseItemVO vo) {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }


    public static class ItemVO extends BaseItemVO {

        public ItemVO() {
            super(1, "text");
        }

        private String mText = "item text view";

        public String getText() {
            return mText;
        }

        public void setText(String text) {
            mText = text;
        }
    }
}
