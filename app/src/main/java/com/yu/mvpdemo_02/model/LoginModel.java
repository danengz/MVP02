package com.yu.mvpdemo_02.model;

import android.os.SystemClock;

import com.yu.mvpdemo_02.base.BaseModel;
import com.yu.mvpdemo_02.bean.UserInfo;
import com.yu.mvpdemo_02.contract.LoginContract;
import com.yu.mvpdemo_02.presenter.LoginPresenter;

public class LoginModel extends BaseModel<LoginPresenter, LoginContract.Model> {


    public LoginModel(LoginPresenter loginPresenter) {
        // 此时通过父类的构造方法把具体的loginPresenter赋值给了BasePresenter中的p
        super(loginPresenter);
    }

    @Override
    public LoginContract.Model getContract() {
        return new LoginContract.Model() {
            @Override
            public void requireLogin(String userName, String password) {
                // 结果返回给Presenter
                if ("123".equals(userName) && "123".equals(password)){
                    p.getContract().responseLogin(new UserInfo("yu"));
                }else {
                    p.getContract().responseLogin(null);
                }
//                内存泄漏测试
//                new Thread(){
//                    @Override
//                    public void run() {
//                        super.run();
//                        SystemClock.sleep(50000);
//                    }
//                }.start();
            }
        };
    }
}
