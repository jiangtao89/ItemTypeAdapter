package com.jt.funny.homepage;

/**
 * Created by jiangtao on 16/5/21.
 *
 * @author jiang.tao
 * @version 1.0.0
 */
public class ItemProperty {

    private int mItemViewType;
    private Class<? extends BaseItemVO> mItemVOClass;
    private Class<? extends ItemView> mItemViewClass;

    public ItemProperty(int itemViewType
            , Class<? extends BaseItemVO> itemVOClass
            , Class<? extends ItemView> itemViewClass) {
        mItemViewType = itemViewType;
        mItemVOClass = itemVOClass;
        mItemViewClass = itemViewClass;
    }

    public int getItemViewType() {
        return mItemViewType;
    }

    public void setItemViewType(int itemViewType) {
        mItemViewType = itemViewType;
    }

    public Class<? extends BaseItemVO> getItemVOClass() {
        return mItemVOClass;
    }

    public void setItemVOClass(Class<? extends BaseItemVO> itemVOClass) {
        mItemVOClass = itemVOClass;
    }

    public Class<? extends ItemView> getItemViewClass() {
        return mItemViewClass;
    }

    public void setItemViewClass(Class<? extends ItemView> itemViewClass) {
        mItemViewClass = itemViewClass;
    }
}
