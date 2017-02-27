package com.example.administrator.demo3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.example.xieyang.base.BaseFragment;
import com.example.xieyang.utils.ShowLog;

import java.util.ArrayList;

public class FragmentController {

	private int containerId;
	private android.support.v4.app.FragmentManager fm;
	private ArrayList<BaseFragment> fragments;
	private Class<BaseFragment>[] frags;
	private FragmentTransaction ft;
	private boolean isAdd0;
	private boolean isAdd1;
	private boolean isAdd2;
	private boolean isAdd3;

	public FragmentController(FragmentActivity aty, Class<BaseFragment>[] frags, int containerId) {
		this.containerId = containerId;
		this.fm = aty.getSupportFragmentManager();
		this.fragments = new ArrayList<BaseFragment>();
		this.frags = frags;
		initFragment();
	}

	private void initFragment() {
		isAdd0 = true;
		isAdd1 = true;
		isAdd2 = true;
		isAdd3 = true;
		for (int i = 0; i < frags.length; i++) {
			try {
				fragments.add(frags[i].newInstance());

			} catch (Exception e) {
				e.printStackTrace();
				ShowLog.showTag("添加fragment失败");
			}

		}

//		FragmentTransaction ft = fm.beginTransaction();
//		for(Fragment fragment : fragments) {
//			ft.add(containerId, fragment);
//		}
//		ft.commit();
	}

	public void showFragment(int pos) {
		FragmentTransaction ft = fm.beginTransaction();


		switch (pos) {
			case 0:
				if (isAdd0) {
					ft.add(containerId, fragments.get(pos), pos + "");
				}
				isAdd0 = false;
				break;
			case 1:
				if (isAdd1) {
					ft.add(containerId, fragments.get(pos), pos + "");
				}
				isAdd1 = false;
				break;
			case 2:
				if (isAdd2) {
					ft.add(containerId, fragments.get(pos), pos + "");
				}
				isAdd2 = false;
				break;
			case 3:
				if (isAdd3) {
					ft.add(containerId, fragments.get(pos), pos + "");
				}
				isAdd3 = false;
				break;
			default:
				break;
		}

		hideFragments(pos);
		Fragment fragment = fragments.get(pos);
		ft.show(fragment);
		ft.commit();
	}

	public void hideFragments(int notIt) {
		FragmentTransaction ft = fm.beginTransaction();
		for (Fragment fragment : fragments) {
			if (fragment != null) {
				String tag = notIt + "";
				if (!tag.equals(fragment.getTag())) {
					ft.hide(fragment);
				}
			}
		}
		ft.commit();
	}
}
