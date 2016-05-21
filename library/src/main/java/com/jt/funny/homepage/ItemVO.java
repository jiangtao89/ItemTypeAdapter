package com.jt.funny.homepage;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jiangtao on 16/5/21.
 *
 * @author jiang.tao
 * @version 1.0.0
 */
public class ItemVO {

    /**
     * module id for statistic
     */
    @SerializedName("moduleId")
    protected long mModuleId;

    /**
     * item view type
     */
    protected int mItemViewType;

    /**
     * item view type describe
     */
    protected String mItemViewTypeDesc = "";

    public ItemVO(int itemViewType, String itemViewTypeDesc) {
        mItemViewType = itemViewType;
        mItemViewTypeDesc = itemViewTypeDesc;
    }

    public long getModuleId() {
        return mModuleId;
    }

    public void setModuleId(long moduleId) {
        mModuleId = moduleId;
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
