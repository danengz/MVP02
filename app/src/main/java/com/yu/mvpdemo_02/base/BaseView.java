package com.yu.mvpdemo_02.base;

import android.app.Activity;
import android.os.Bundle;

//这里继承Activity，当然也可以是其他Fragment或者其他View
public abstract class BaseView<P extends BasePresenter, CONTRACT> extends Activity {

    protected P p;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p = getPresenter();
//        p.v = this;//强引用会导致内存泄漏
        p.bindView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 和Presenter解绑
        p.unBindView();
    }

    // 这个Presenter具体是哪个类只有到具体业务才知道，所以这个Presenter的赋值需要由具体的子类实现
    public abstract P getPresenter();

    // 获取具体协议
    // 协议规定了Presenter怎么和View沟通
    public abstract CONTRACT getContract();
}
