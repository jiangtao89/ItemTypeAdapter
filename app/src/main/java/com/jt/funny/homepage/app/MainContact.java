package com.jt.funny.homepage.app;

import com.jt.funny.homepage.ItemVO;

import java.util.List;

/**
 * Created by jiangtao on 16/5/22.
 *
 * @author jiangtao
 * @version 1.0.0
 */
public interface MainContact {

    /**
     * Created by jiangtao on 16/5/22.
     *
     * @author jiangtao
     * @version 1.0.0
     */
    interface MainView {

        void updateData(List<ItemVO> data);

        void showError();
    }

    /**
     * Created by jiangtao on 16/5/22.
     *
     * @author jiangtao
     * @version 1.0.0
     */
    interface MainPresenter {

        void request();
    }
}
