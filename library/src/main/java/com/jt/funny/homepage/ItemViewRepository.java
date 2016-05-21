package com.jt.funny.homepage;

import java.util.HashMap;

/**
 * Created by jiangtao on 16/5/21.
 *
 * @author jiang.tao
 * @version 1.0.0
 */
public class ItemViewRepository {

    private HashMap<String, ItemProperty> mItemViews = new HashMap<>();

    public static final NullableItemProperty NULLABLE_ITEM_VIEW_PROPERTY = new NullableItemProperty();

    private static volatile ItemViewRepository sInstance = null;


    /**
     * single instance
     *
     * @return ItemViewRepository
     */
    public static ItemViewRepository getInstance() {
        if (sInstance == null) {
            synchronized (ItemViewRepository.class) {
                if (sInstance == null) {
                    sInstance = new ItemViewRepository();
                }
            }
        }
        return sInstance;
    }

    private ItemViewRepository() {
    }

    /**
     * register item view
     *
     * @param key      key
     * @param property property
     */
    public void registerItemView(String key, ItemProperty property) {
        mItemViews.put(key, property);
    }

    /**
     * get item view vo
     *
     * @param key key
     * @return class of item view vo
     */
    public Class<? extends BaseItemVO> getItemVO(String key) {
        return getProperty(key).getItemVOClass();
    }

    /**
     * get item view type
     *
     * @param key key
     * @return type
     */
    public int getItemViewType(String key) {
        return getProperty(key).getItemViewType();
    }

    /**
     * get item view
     *
     * @param key key
     * @return class of item view
     */
    public Class<? extends ItemView> getItemView(String key) {
        return getProperty(key).getItemViewClass();
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

}
