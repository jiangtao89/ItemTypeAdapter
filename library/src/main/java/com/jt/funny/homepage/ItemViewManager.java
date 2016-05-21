package com.jt.funny.homepage;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by jiangtao on 16/5/21.
 *
 * @author jiang.tao
 * @version 1.0.0
 */
public class ItemViewManager {

    private HashMap<String, ItemProperty> mItemViews = new HashMap<>();

    public static final NullableItemProperty NULLABLE_ITEM_VIEW_PROPERTY = new NullableItemProperty();

    private static volatile ItemViewManager sInstance = null;

    private ItemViewFactory mItemViewFactory;


    /**
     * single instance
     *
     * @return ItemViewRepository
     */
    public static ItemViewManager getInstance() {
        if (sInstance == null) {
            synchronized (ItemViewManager.class) {
                if (sInstance == null) {
                    sInstance = new ItemViewManager();
                }
            }
        }
        return sInstance;
    }

    private ItemViewManager() {
        mItemViewFactory = new ItemViewFactoryDefault(this);
    }

    /**
     * set item view factory
     *
     * @param itemViewFactory itemViewFactory
     */
    public void setItemViewFactory(ItemViewFactory itemViewFactory) {
        if (mItemViewFactory == null) {
            return;
        }
        mItemViewFactory = itemViewFactory;
    }

    /**
     * add item view
     *
     * @param key      key of item view type
     * @param property property
     */
    public void add(String key, ItemProperty property) {
        if (key == null || key.length() == 0) {
            return;
        }

        if (property == null) {
            return;
        }
        mItemViews.put(key, property);
    }

    /**
     * get item view vo
     *
     * @param type type of item view type
     * @return class of item view vo
     */
    public Class<? extends ItemVO> getItemVO(String type) {
        return getProperty(type).getItemVOClass();
    }

    /**
     * get item view type
     *
     * @param type type of item view type
     * @return type
     */
    public int getItemViewType(String type) {
        return getProperty(type).getItemViewType();
    }

    /**
     * get item view
     *
     * @param type type of item view type
     * @return class of item view
     */
    public Class<? extends ItemView> getItemView(String type) {
        return getProperty(type).getItemViewClass();
    }

    private ItemProperty getProperty(String key) {
        ItemProperty property = mItemViews.get(key);
        if (property == null) {
            property = NULLABLE_ITEM_VIEW_PROPERTY;
        }
        return property;
    }

    /**
     * item type count
     *
     * @return count of item type
     */
    public int getTypeCount() {
        return mItemViews.size();
    }

    /**
     * create item view
     *
     * @param context context
     * @param itemVO  item VO
     * @return
     */
    public ItemView createItemView(Context context, ItemVO itemVO) {
        return mItemViewFactory.createItemView(context, itemVO);
    }

}
