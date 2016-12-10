package kjj.alibaba.com.kjj;

import android.app.Application;
import android.util.Log;

/**
 * Created by zed.qzq on 2016/12/9.
 */

public class MyApplication extends Application {
    public static final String TAG = "九大恶煞";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "MyApplication......onCreate()方法");
    }
}
