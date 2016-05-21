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
    private ItemViewFactory mItemViewFactory;
    private ItemViewRepository mItemViewRepository;
    private List<BaseItemVO> mItemVOs = new ArrayList<>();

    /**
     * @param context         context
     * @param itemViewRepository itemViewRepository
     * @param factory         factory
     */
    public ItemTypeAdapter(Context context, ItemViewRepository itemViewRepository, ItemViewFactory factory) {
        mContext = context;
        mItemViewRepository = itemViewRepository;
        mItemViewFactory = factory;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * update adapter data
     *
     * @param data data
     */
    public void setData(List<BaseItemVO> data) {
        if (data == null || data.size() == 0) {
            mItemVOs.clear();
            notifyDataSetChanged();
            return;
        }

        mItemVOs = new ArrayList<>(data);
        notifyDataSetChanged();
    }

    public void addData(List<BaseItemVO> data) {
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
    public BaseItemVO getItem(int position) {
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
        return mItemViewRepository.getTypeCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemView itemView = null;
        BaseItemVO itemVO = getItem(position);
        if (convertView == null) {
            // create item view from item view factory
            itemView = mItemViewFactory.createItemView(itemVO);
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
