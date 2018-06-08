package cn.sibat.pushdemo;

import android.app.Application;
import android.content.Context;

import cn.jpush.android.api.JPushInterface;

public class MyApplication extends Application{
    public static Context applicationContext;
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
        instance = this;
        //initOkGo();
        //初始化sdk
        JPushInterface.setDebugMode(true);//正式版的时候设置false，关闭调试
        JPushInterface.init(this);
        //建议添加tag标签，发送消息的之后就可以指定tag标签来发送了
       /* Set<String> set = new HashSet<>();
        set.add("andfixdemo");//名字任意，可多添加几个
        JPushInterface.setTags(this, set, null);//设置标签*/

    }
    public static MyApplication getInstance() {
        return instance;
    }
}
