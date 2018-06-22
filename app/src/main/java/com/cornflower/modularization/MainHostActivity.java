package com.cornflower.modularization;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainHostActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_host);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.tv, R.id.tv_open_acconut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv:
                ARouter.getInstance().build("/regist/RegistMainActivity").navigation();
                break;
            case R.id.tv_open_acconut:
                ARouter.getInstance().build("/openAccount/OpenAccountActivity").navigation();
                break;
        }
    }
}
