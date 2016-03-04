package zs.com.lbt.ui.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import rx.subscriptions.CompositeSubscription;
import zs.com.lbt.app.ApiManger;
import zs.com.lbt.app.LbtApplication;
import zs.com.lbt.helper.SpfHelper;
import zs.com.lbt.util.SystemBarTintManager;

/**
 * Created by cq on 2016/2/1.
 */
public abstract class NoBackBaseActivity extends AppCompatActivity{
    protected SpfHelper _SpfHelper;
    protected LbtApplication _LbtApplication;
    private SystemBarTintManager _mTintManager;
    protected CompositeSubscription _CompositeSubscription=new CompositeSubscription();
    protected ApiManger _apiManger=ApiManger.getInstance();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTanslucent();
        _LbtApplication=LbtApplication.getInstance();
        _SpfHelper=_LbtApplication.getSpfHelper();

    }

    private void setTanslucent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        _mTintManager = new SystemBarTintManager(this);
        _mTintManager.setNavigationBarTintEnabled(true);// 激活导航栏设置
        _mTintManager.setStatusBarTintEnabled(true);
        _mTintManager.setStatusBarTintResource(android.R.color.white);
        _mTintManager.setStatusBarDarkMode(true, this);

    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    protected void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    protected void onDestroy() {
        _CompositeSubscription.unsubscribe();
        super.onDestroy();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected abstract void initView();
    protected abstract void initData();
}
