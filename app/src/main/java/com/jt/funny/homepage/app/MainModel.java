package com.jt.funny.homepage.app;

import com.jt.funny.homepage.ItemVO;

import java.util.List;

/**
 * Created by jiangtao on 16/5/22.
 *
 * @author jiangtao
 * @version 1.0.0
 */
public interface MainModel {

    void request(Callback callback);

    static interface Callback {

        void success(List<ItemVO> data);

        void failed();
    }
}
