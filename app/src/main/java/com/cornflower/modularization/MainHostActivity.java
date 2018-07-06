package com.cornflower.modularization;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cornflower.basemoudle.TakePhoto.TakePhotoManager;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainHostActivity extends AppCompatActivity {

    TakePhotoManager takePhotoManager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_host);
        ButterKnife.bind(this);
        takePhotoManager = new TakePhotoManager(this);

    }

    @OnClick({R.id.tv, R.id.tv_open_acconut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv:
//                ARouter.getInstance().build("/regist/RegistMainActivity").navigation();
                try {

                    startActivityForResult(takePhotoManager.dispatchTakePictureIntent(),1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.tv_open_acconut:
                ARouter.getInstance().build("/openAccount/OpenAccountActivity").navigation();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(RESULT_OK == resultCode){
            Log.i("takePhotoManager_path",takePhotoManager.getCurrentPhotoPath());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        takePhotoManager.onSaveInstanceState(outState);
        Log.i("takePhotoManager_path","onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i("takePhotoManager_path","onRestoreInstanceState");
        takePhotoManager.onRestoreInstanceState(savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
    }
}
