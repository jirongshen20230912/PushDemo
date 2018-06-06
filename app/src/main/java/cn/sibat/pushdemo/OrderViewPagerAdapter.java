package cn.sibat.pushdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

//订单viewpager适配
public class OrderViewPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment> mlist;

	public OrderViewPagerAdapter(FragmentManager fm, List<Fragment> mlist) {
		super(fm);
		this.mlist = mlist;
	}

	@Override
	public Fragment getItem(int position) {
		return mlist.get(position);
	}

	@Override
	public int getCount() {
		return mlist.size();
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
	}
}
