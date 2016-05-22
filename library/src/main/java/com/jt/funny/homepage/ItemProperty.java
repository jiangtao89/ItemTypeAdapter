package com.jt.funny.homepage;

/**
 * Created by jiangtao on 16/5/21.
 *
 * @author jiang.tao
 * @version 1.0.0
 */
public class ItemProperty {

    private int mItemViewType;
    private Class<? extends ItemVO> mItemVOClass;
    private Class<? extends ItemView> mItemViewClass;

    public ItemProperty(Class<? extends ItemVO> itemVOClass
            , Class<? extends ItemView> itemViewClass) {
        mItemVOClass = itemVOClass;
        mItemViewClass = itemViewClass;
    }

    public int getItemViewType() {
        return mItemViewType;
    }

    public void setItemViewType(int itemViewType) {
        mItemViewType = itemViewType;
    }

    public Class<? extends ItemVO> getItemVOClass() {
        return mItemVOClass;
    }

    public void setItemVOClass(Class<? extends ItemVO> itemVOClass) {
        mItemVOClass = itemVOClass;
    }

    public Class<? extends ItemView> getItemViewClass() {
        return mItemViewClass;
    }

    public void setItemViewClass(Class<? extends ItemView> itemViewClass) {
        mItemViewClass = itemViewClass;
    }
}
