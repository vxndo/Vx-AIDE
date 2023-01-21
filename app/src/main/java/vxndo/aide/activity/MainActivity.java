package vxndo.aide.activity;

import android.app.*;
import android.os.*;
import vxndo.aide.*;
import vxndo.aide.fragment.manager.*;
import vxndo.aide.fragment.*;

public class MainActivity
extends Activity {

	private EditorFragment mEditorFragment;
	private VxFragmentManager mFragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		mEditorFragment = new EditorFragment();
		mFragmentManager = new VxFragmentManager(this);
		
		mFragmentManager.replace(mEditorFragment, R.id.main_activity_fragment);
	}
}
