package com.yu.mvpdemo_02.bean;

public class UserInfo extends BaseResponseBean {

    private String nickName;

    public UserInfo(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
