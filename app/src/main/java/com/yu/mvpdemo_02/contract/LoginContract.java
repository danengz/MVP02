package com.yu.mvpdemo_02.contract;

import com.yu.mvpdemo_02.bean.BaseResponseBean;

public interface LoginContract {

    interface View<T extends BaseResponseBean> {
        void responseLogin(T t);//-------------------------------------4
    }

    interface Presenter<T extends BaseResponseBean> {
        void requireLogin(String userName, String password);//---------1
        void responseLogin(T t);//-------------------------------------3
    }

    interface Model {
        void requireLogin(String userName, String password);//---------2
    }

}
