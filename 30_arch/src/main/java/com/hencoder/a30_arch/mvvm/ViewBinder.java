package com.hencoder.a30_arch.mvvm;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.Objects;

public class ViewBinder {
    void bind(final EditText editText, final ViewModel.StringAttr datum) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!Objects.equals(s.toString(), datum.getValue())) {
                    datum.setValue(s.toString());
                }
            }
        });
        datum.setOnChangeListener(new ViewModel.StringAttr.OnChangeListener() {
            @Override
            public void onChange(String newValue) {
                if (!Objects.equals(newValue, editText.getText().toString())) {
                    editText.setText(newValue);
                }
            }
        });
    }
}
