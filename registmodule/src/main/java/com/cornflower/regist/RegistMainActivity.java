package com.cornflower.regist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/regist/RegistMainActivity")
public class RegistMainActivity extends AppCompatActivity {


    @BindView(R2.id.tv_regist)
    TextView tvRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_main);
        ButterKnife.bind(this);
    }


    @OnClick(R2.id.tv_regist)
    public void onViewClicked() {
        ARouter.getInstance().build("/openAccount/OpenAccountActivity").navigation();

    }
}
