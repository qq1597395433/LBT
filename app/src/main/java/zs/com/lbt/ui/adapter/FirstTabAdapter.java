package zs.com.lbt.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import zs.com.lbt.ui.fragment.BaseFragment;
import zs.com.lbt.ui.fragment.FirstTabFragment;

/**
 * Created by cq on 2016/2/2.
 */
public class FirstTabAdapter extends FragmentPagerAdapter{
    private String [] titles;
    public FirstTabAdapter(FragmentManager fm, String [] titles) {
        super(fm);
        this.titles=titles;
    }


    @Override
    public Fragment getItem(int position) {
        return FirstTabFragment.getInstance(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
