package vxndo.aide.widget;

import android.content.*;
import android.graphics.*;
import android.util.*;
import android.view.*;
import android.widget.*;

public class ShortcutView
extends HorizontalScrollView
implements View.OnClickListener {

	private LinearLayout layout;
	private EditText mEditText;

	public ShortcutView(Context context) {
		super(context);
		setHorizontalScrollBarEnabled(false);
		setBackgroundColor(0xff212121);
		layout = new LinearLayout(context);
		layout.setLayoutParams(new LayoutParams(-1, -1));
	}

	public void link(EditText editText) {
		mEditText = editText;
	}

	@Override
	public void onClick(View p1) {
		int index = mEditText.getSelectionStart();
		mEditText.getText().insert(index, ((Shortcut)p1).data);
	}

	public void makeShortcuts(String[] values) {
		for (int i = 0; i < values.length; i++) {
			Shortcut shortcut = new Shortcut(getContext(), values[i]);
			shortcut.setOnClickListener(this);
			layout.addView(shortcut, new LayoutParams(100, 100));
		} addView(layout);
	}

	public static class Shortcut
	extends Button {

		private String data;

		public Shortcut(Context context, String shortcut) {
			super(context);
			data = shortcut.replace("⇥","\t");
			setText(shortcut);
			setTextAlignment(TEXT_ALIGNMENT_CENTER);
			setTextSize(getTextSize()*1.0f);
			setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
			TypedValue value = new TypedValue();
			context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, value, true);
			setBackground(context.getDrawable(value.resourceId));
		}
	}
}
