package zs.com.lbt.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zs.com.lbt.R;

/**
 * Created by cq on 2016/2/2.
 */
public class ThirdFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_third, container, false);
        initView();
        return v;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

    }

}
