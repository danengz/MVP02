package com.yu.mvpdemo_02.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M extends BaseModel, V extends BaseView, CONTRACT> {

    protected M m;
//    不能才用强引用，会发送内存泄漏
//    protected V v;

//    弱引用
    private WeakReference<V> vWeakReference;

    public BasePresenter() {
        m = getModel();
    }

//    弱引用绑定
    public void bindView(V v) {
        vWeakReference = new WeakReference<V>(v);
    }

//    弱引用解绑，回收
    public void unBindView() {
        if (vWeakReference != null) {
            vWeakReference.clear();
            vWeakReference = null;
            System.gc();
        }
    }

//    提供弱引用获取方法
    public V getView(){
        if (vWeakReference != null) {
            return vWeakReference.get();
        }
        return null;
    }

    public abstract M getModel();

    public abstract CONTRACT getContract();
}
