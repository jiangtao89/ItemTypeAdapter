package com.jt.funny.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangtao on 16/5/21.
 *
 * @author jiang.tao
 * @version 1.0.0
 */
public class ItemTypeAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ItemViewManager mItemViewManager;
    private List<ItemVO> mItemVOs = new ArrayList<>();

    /**
     * @param context         context
     * @param itemViewManager itemViewRepository
     */
    public ItemTypeAdapter(Context context, ItemViewManager itemViewManager) {
        mContext = context;
        mItemViewManager = itemViewManager;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * update adapter data
     *
     * @param data data
     */
    public void setData(List<ItemVO> data) {
        if (data == null || data.size() == 0) {
            mItemVOs.clear();
            notifyDataSetChanged();
            return;
        }

        mItemVOs = new ArrayList<>(data);
        notifyDataSetChanged();
    }

    public void addData(List<ItemVO> data) {
        if (data == null || data.size() == 0) {
            return;
        }

        mItemVOs.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mItemVOs.size();
    }

    @Override
    public ItemVO getItem(int position) {
        return mItemVOs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getItemViewType();
    }

    @Override
    public int getViewTypeCount() {
        return mItemViewManager.getTypeCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemView itemView = null;
        final ItemVO itemVO = getItem(position);
        if (convertView == null) {
            // create item view from item view factory
            itemView = mItemViewManager.createItemView(mContext, itemVO);
            // create nullable item view
            if (itemView == null) {
                itemView = new NullableItemView(mContext);
            }
            // create item view
            convertView = itemView.onCreateView(position, convertView, parent, mLayoutInflater, itemVO);

            convertView.setTag(itemView);
        } else {
            itemView = (ItemView) convertView.getTag();
        }
        // bind view
        itemView.onBindView(position, convertView, parent, itemVO);
        return convertView;
    }
}
