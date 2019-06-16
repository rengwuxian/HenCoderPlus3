package com.hencoder.a30_arch.mvp;

import com.hencoder.a30_arch.data.DataCenter;

public class Presenter {
    IView iView;

    Presenter(IView iView) {
        this.iView = iView;
    }

    public void load() {
        String[] data = DataCenter.getData();
        iView.showData(data[0], data[1]);
    }

    interface IView {
        void showData(String datum0, String datum1);
    }

}
