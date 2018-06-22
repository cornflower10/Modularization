package com.cornflower.modularization;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cornflower.basemoudle.BaseApplication;

/**
 * Created by xiejingbao on 2018/6/21.
 */

public class AppHost  extends BaseApplication{
    @Override
    public void onCreate() {
        super.onCreate();


        if(BuildConfig.DEBUG){
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();// 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init( this ); // 尽可能早，推荐在Application中初始化
    }
}
