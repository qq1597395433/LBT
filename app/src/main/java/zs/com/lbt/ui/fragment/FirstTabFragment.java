package zs.com.lbt.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import zs.com.lbt.R;
import zs.com.lbt.bean.CeShiBean;
import zs.com.lbt.customerview.ClearFocusRecyclerView;
import zs.com.lbt.ui.activity.MainActivity;
import zs.com.lbt.ui.adapter.FirstTabRcyAdapter;

/**
 * Created by cq on 2016/2/2.
 */
public class FirstTabFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{


    @Bind(R.id.rcyView)
    ClearFocusRecyclerView rcyView;
    @Bind(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;
    private   List<CeShiBean> datas=new ArrayList<>();
    private InputMethodManager imm;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first_tab, container, false);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }

    @Override
    protected void initView() {
        if (getArguments() != null) {
//         getArguments().getInt("position",0)+"";
        }
        imm=(InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        FirstTabRcyAdapter adapter=new FirstTabRcyAdapter(getActivity(),datas);
        rcyView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        rcyView.setAdapter(adapter);
        rcyView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(imm.isActive()){
                    imm.hideSoftInputFromWindow(rcyView.getWindowToken(), 0);
                }
            }
        });
    }

    @Override
    protected void initEvent() {
        swipeRefresh.setOnRefreshListener(this);
    }


    public static FirstTabFragment getInstance(int position) {
        FirstTabFragment fragment = new FirstTabFragment();
        Bundle b = new Bundle();
        b.putInt("position", position);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onRefresh() {
        swipeRefresh.setRefreshing(false);
    }
}
