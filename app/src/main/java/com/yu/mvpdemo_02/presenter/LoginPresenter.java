package com.yu.mvpdemo_02.presenter;

import com.yu.mvpdemo_02.base.BasePresenter;
import com.yu.mvpdemo_02.bean.BaseResponseBean;
import com.yu.mvpdemo_02.bean.UserInfo;
import com.yu.mvpdemo_02.contract.LoginContract;
import com.yu.mvpdemo_02.model.LoginModel;
import com.yu.mvpdemo_02.view.LoginActivity;

public class LoginPresenter extends BasePresenter<LoginModel, LoginActivity, LoginContract.Presenter> {


    @Override
    public LoginModel getModel() {
        return new LoginModel(this);
    }

    @Override
    public LoginContract.Presenter getContract() {
        return new LoginContract.Presenter<UserInfo>() {
            @Override
            public void requireLogin(String userName, String password) {
                // 任务发送给Model
                m.getContract().requireLogin(userName, password);
            }

            @Override
            public void responseLogin(UserInfo userInfo) {
                // 结果返回给Presenter
                // Presenter不在持有v，不能通过v.getContract().responseLogin(userInfo)去调用，通过getView()获取对View的弱引用;
                getView().getContract().responseLogin(userInfo);
            }
        };
    }
}
