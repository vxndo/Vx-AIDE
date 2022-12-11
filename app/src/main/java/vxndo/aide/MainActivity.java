package vxndo.aide;

import android.app.*;
import android.os.*;
import android.widget.*;
import vxndo.widget.viewpager.*;

public class MainActivity extends Activity {

	FragmentTransaction transaction;
	Toolbar toolbar;
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		toolbar = findViewById(R.id.main_activity_toolbar);
		setActionBar(toolbar);
		transaction = getFragmentManager().beginTransaction();
	}

	public void replaceFragment(Fragment fragment) {
		transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
		transaction.replace(R.id.main_fragment, fragment);
		transaction.commit();
	}
}
