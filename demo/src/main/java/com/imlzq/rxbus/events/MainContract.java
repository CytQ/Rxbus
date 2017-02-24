package com.imlzq.rxbus.events;

import com.imlzq.rxbus.base.BasePresenter;
import com.imlzq.rxbus.base.BaseView;

/**
 * Created by lizhongquan on 2017/2/24.
 */

public class MainContract {

    interface Presenter extends BasePresenter {

    }

    interface View extends BaseView<Presenter> {

        void showMsg(String eventName);
    }
}
