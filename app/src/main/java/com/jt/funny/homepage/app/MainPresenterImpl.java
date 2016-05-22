package com.jt.funny.homepage.app;

import com.jt.funny.homepage.ItemVO;

import java.util.List;

/**
 * Created by jiangtao on 16/5/22.
 *
 * @author jiangtao
 * @version 1.0.0
 */
public class MainPresenterImpl implements MainContact.MainPresenter {

    private MainContact.MainView mView;

    private MainModel mMainModel;

    public MainPresenterImpl(MainContact.MainView view) {
        mView = view;
        mMainModel = new MainModelImpl();
    }

    @Override
    public void request() {
        mMainModel.request(new MainModel.Callback() {
            @Override
            public void success(List<ItemVO> data) {
                mView.updateData(data);
            }

            @Override
            public void failed() {

            }
        });
    }
}
