package zs.com.lbt.app;

import android.app.Application;

import zs.com.lbt.helper.SpfHelper;

/**
 * Created by cq on 2016/2/1.
 */
public class LbtApplication extends Application {
    private static LbtApplication _LbtApplication;
    private SpfHelper _SpfHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        _LbtApplication = this;
        _SpfHelper=getSpfHelper();
    }

    public static synchronized LbtApplication getInstance() {
        return _LbtApplication;
    }

    public SpfHelper  getSpfHelper(){
        if(_SpfHelper==null){
            synchronized(SpfHelper.class){
                if(_SpfHelper==null){
                    _SpfHelper=new SpfHelper(this,Constants.SPF_KEY_USER);
                }
            }
        }
        return _SpfHelper;
    }
}
