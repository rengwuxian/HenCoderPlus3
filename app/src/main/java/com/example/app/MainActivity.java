package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app.entity.User;
import com.example.app.widget.CodeView;
import com.example.core.utils.CacheUtils;
import com.example.core.utils.Utils;
import com.example.lesson.LessonActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String usernameKey = "username";
    private final String passwordKey = "password";

    private EditText et_username;
    private EditText et_password;
    private EditText et_code;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_code = findViewById(R.id.et_code);

        et_username.setText(CacheUtils.get(usernameKey));
        et_password.setText(CacheUtils.get(passwordKey));

        final Button btn_login = findViewById(R.id.btn_login);
        final CodeView img_code = findViewById(R.id.code_view);
        btn_login.setOnClickListener(this);
        img_code.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof CodeView) {
            CodeView codeView = (CodeView) v;
            codeView.updateCode();
        } else if (v instanceof Button) {
            login();
        }
    }

    private void login() {
        final String username = et_username.getText().toString();
        final String password = et_password.getText().toString();
        final String code = et_code.getText().toString();

        final User user = new User(username, password, code);
        if (verify(user)) {
            CacheUtils.save(usernameKey, username);
            CacheUtils.save(passwordKey, password);
            startActivity(new Intent(this, LessonActivity.class));
        }
    }

    private boolean verify(User user) {
        if (user.getUsername() != null && user.getUsername().length() < 4) {
            Utils.toast("用户名不合法");
            return false;
        }
        if (user.getPassword() != null && user.getPassword().length() < 4) {
            Utils.toast("密码不合法");
            return false;
        }
        return true;
    }
}
