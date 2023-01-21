package vxndo.aide.fragment.manager;

import android.app.*;

public class VxFragmentManager {

	private Activity mActivity;
	private FragmentTransaction mFragmentTransaction;

	public VxFragmentManager(Activity activity) {
		mActivity = activity;
	}

	public void replace(Fragment fragment, int id) {
		mFragmentTransaction = mActivity.getFragmentManager().beginTransaction();
		mFragmentTransaction.replace(id, fragment);
		mFragmentTransaction.commit();
	}
}
