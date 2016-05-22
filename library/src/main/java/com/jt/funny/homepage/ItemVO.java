package com.jt.funny.homepage;

/**
 * Created by jiangtao on 16/5/21.
 *
 * @author jiang.tao
 * @version 1.0.0
 */
public class ItemVO {
    /**
     * item view type describe
     */
    protected String mItemViewTypeDesc = "nullable";

    public ItemVO(String itemViewTypeDesc) {
        mItemViewTypeDesc = itemViewTypeDesc;
    }

    public ItemVO() {
    }

    public String getItemViewTypeDesc() {
        return mItemViewTypeDesc;
    }

    public void setItemViewTypeDesc(String itemViewTypeDesc) {
        mItemViewTypeDesc = itemViewTypeDesc;
    }
}
