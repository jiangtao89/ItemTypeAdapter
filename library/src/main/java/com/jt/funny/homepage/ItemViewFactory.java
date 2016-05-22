package com.jt.funny.homepage;

import android.content.Context;

/**
 * Created by jiangtao on 16/5/22.
 *
 * @author jiangtao
 * @version 1.0.0
 */
public interface ItemViewFactory {
    /**
     * create item view
     *
     * @param itemVO item view object
     * @return item view
     */
    ItemView createItemView(Context context,ItemVO itemVO);
}
