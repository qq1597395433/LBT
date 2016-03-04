package zs.com.lbt.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import zs.com.lbt.R;

/**
 * Created by cq on 2016/3/3.
 */
public class SecondActivity extends BaseActivity {

    @Bind(R.id.iv_home)
    ImageButton ivHome;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        initView();
        initEvent();
    }

    @Override
    protected void initView() {
        tvTitle.setText("第二页");

    }

    @Override
    protected void initEvent() {
        btn.setOnClickListener(v -> startActivity(new Intent(this, SecondActivity.class)));
        ivHome.setOnClickListener(v -> finish());
    }

}
