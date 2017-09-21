package Wangye.myapplication;

import android.app.Application;

/**
 * date 2017/9/19
 * functinn:
 */

public class CrashApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
    }
}
