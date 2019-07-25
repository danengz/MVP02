package com.yu.mvpdemo_02.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yu.mvpdemo_02.R;
import com.yu.mvpdemo_02.base.BasePresenter;
import com.yu.mvpdemo_02.base.BaseView;
import com.yu.mvpdemo_02.bean.UserInfo;
import com.yu.mvpdemo_02.contract.LoginContract;
import com.yu.mvpdemo_02.presenter.LoginPresenter;

public class LoginActivity extends BaseView<LoginPresenter, LoginContract.View> {

    private EditText et_username;
    private EditText et_pwd;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initOnclickListener();
    }

    private void initView() {
        et_username = findViewById(R.id.et_username);
        et_pwd = findViewById(R.id.et_pwd);
        button = findViewById(R.id.btn_login);
    }

    private void initOnclickListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // p已通过getPresenter赋值
                p.getContract().requireLogin(et_username.getText().toString(), et_pwd.getText().toString());
            }
        });
    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    public LoginContract.View getContract() {
        return new LoginContract.View<UserInfo>() {
            @Override
            public void responseLogin(UserInfo userInfo) {
                Toast.makeText(LoginActivity.this, userInfo == null ? "登录失败" : "登录成功：" + userInfo.getNickName(), Toast.LENGTH_LONG).show();
            }
        };
    }

}
