package vxndo.aide;

import android.app.*;
import android.content.*;
import android.preference.*;

public class App extends Application {

	public static SharedPreferences sp;
	public static SharedPreferences.Editor spe;

	@Override
	public void onCreate() {
		super.onCreate();
		sp = PreferenceManager.getDefaultSharedPreferences(this);
		spe = sp.edit();
	}
}
