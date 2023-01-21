package vxndo.aide.widget.text;

import android.text.*;
import android.text.style.*;

public class EditorWatcher
implements TextWatcher {

	private int mTabWidth;
	private int start, count;
	String[] keys = {"public","private","protected","void","null","int",};

	public void setTabWidth(int tabWidth) {
		mTabWidth = tabWidth;
	}

	@Override
	public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4) {}

	@Override
	public void onTextChanged(CharSequence p1, int p2, int p3, int p4) {
		start = p2;
		count = p4;
	}

	@Override
	public void afterTextChanged(Editable p1) {
		String s = p1.toString();
		for (int stop = start + count; (start = s.indexOf("\t", start)) > -1 && start < stop; ++start) {
			p1.setSpan(new TabSpan(mTabWidth), start, start+1, 33);
		} for (String key: keys) {
			if (s.contains(key)) {
				int index = s.lastIndexOf(key);
				int lenght = key.length();
				//p1.setSpan(new ForegroundColorSpan(0xffff0000), index, index+lenght, p1.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
		}
	}
}
