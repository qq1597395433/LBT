package zs.com.lbt.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import zs.com.lbt.R;
import zs.com.lbt.ui.adapter.FirstTabAdapter;
import zs.com.lbt.util.ToastUtil;

public class MainActivity extends NoBackBaseActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @Bind(R.id.drawlayout)
    DrawerLayout drawlayout;
    private FirstTabAdapter adapter;
    private ActionBarDrawerToggle mDrawToggle;
    private View headView;
    // 再点一次退出程序时间设置
    long WAIT_TIME = 2000;
    long TOUCH_TIME = 0;
    private TextView tv_name;
    private CircleImageView iv_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    protected void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
    }


    protected void initData() {
        mDrawToggle = new ActionBarDrawerToggle(this, drawlayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawToggle.syncState();
        drawlayout.setDrawerListener(mDrawToggle);
        headView = navigationView.getChildAt(0);
        tv_name = (TextView) headView.findViewById(R.id.tv_name);
        iv_icon = (CircleImageView) headView.findViewById(R.id.iv_icon);

        navigationView.setNavigationItemSelectedListener(menuItem -> {
//            switch (menuItem.getItemId()) {
//                case R.id.navigation_item_about:
                    startActivity(new Intent(MainActivity.this,SecondActivity.class));
//                    break;
//            }
            menuItem.setChecked(true);
            drawlayout.closeDrawers();
            return true;
        });

        String[] titles = getResources().getStringArray(R.array.menu_first);
        adapter = new FirstTabAdapter(getSupportFragmentManager(), titles);
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabMode(TabLayout.MODE_FIXED);
    }

    private void setFragmentIndicator(int current_position) {
        viewPager.setCurrentItem(current_position);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (drawlayout.isDrawerOpen(Gravity.LEFT)) {
            drawlayout.closeDrawer(Gravity.LEFT);
        } else {
            if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
                finish();
            } else {
                TOUCH_TIME = System.currentTimeMillis();
                ToastUtil.showShort(this, R.string.press_again_exit);
            }
        }
    }
}
