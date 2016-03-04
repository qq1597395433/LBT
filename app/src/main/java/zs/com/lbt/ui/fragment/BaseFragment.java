package zs.com.lbt.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import rx.subscriptions.CompositeSubscription;
import zs.com.lbt.app.ApiManger;
import zs.com.lbt.app.LbtApplication;
import zs.com.lbt.helper.SpfHelper;

/**
 * Created by cq on 2016/2/1.
 */
public abstract class BaseFragment extends Fragment{
    protected Activity _Activity;
    protected SpfHelper _SpfHelper;
    protected LbtApplication _LbtApplication;
    protected CompositeSubscription _CompositeSubscription=new CompositeSubscription();
    protected ApiManger _apiManger=ApiManger.getInstance();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _LbtApplication=LbtApplication.getInstance();
        _SpfHelper=_LbtApplication.getSpfHelper();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        _Activity=activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        _CompositeSubscription.unsubscribe();
    }

    protected abstract void initView();
    protected abstract void initEvent();
}
