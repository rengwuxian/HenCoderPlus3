package com.hencoder.a30_arch.mvvm;

import android.widget.EditText;

import com.hencoder.a30_arch.data.DataCenter;

public class ViewModel {
    StringAttr datum0 = new StringAttr();
    StringAttr datum1 = new StringAttr();

    ViewModel(ViewBinder binder, EditText editText0, EditText editText1) {
        binder.bind(editText0, datum0);
        binder.bind(editText1, datum1);
    }

    public void load() {
        String[] data = DataCenter.getData();
        datum0.setValue(data[0]);
        datum1.setValue(data[1]);
    }

    static class StringAttr {
        private String value;
        OnChangeListener listener;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
            System.out.println("我被被动修改了：" + value);
            if (listener != null) {
                listener.onChange(value);
            }
        }

        void setOnChangeListener(OnChangeListener listener) {
            this.listener = listener;
        }

        interface OnChangeListener {
            void onChange(String newValue);
        }
    }
}
