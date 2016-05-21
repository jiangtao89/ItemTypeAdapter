package com.jt.funny.homepage;

/**
 * Created by jiangtao on 16/5/21.
 *
 * @author jiang.tao
 * @version 1.0.0
 */
public class BaseItemVO {

    protected long mModuleID;

    /**
     * item view type
     */
    protected int mItemViewType;

    /**
     * item view type describe
     */
    protected String mItemViewTypeDesc = "";

    public BaseItemVO(int itemViewType, String itemViewTypeDesc) {
        mItemViewType = itemViewType;
        mItemViewTypeDesc = itemViewTypeDesc;
    }

    public int getItemViewType() {
        return mItemViewType;
    }

    public void setItemViewType(int itemViewType) {
        mItemViewType = itemViewType;
    }

    public String getItemViewTypeDesc() {
        return mItemViewTypeDesc;
    }

    public void setItemViewTypeDesc(String itemViewTypeDesc) {
        mItemViewTypeDesc = itemViewTypeDesc;
    }
}
