package vxndo.aide.widget.text;

import android.text.style.*;
import android.graphics.*;
import android.graphics.Paint.*;

public class TabSpan
extends ReplacementSpan {

	private int mTabWidth;

	public TabSpan(int tabWidth) {
		mTabWidth = tabWidth;
	}

	@Override
	public int getSize(Paint p1, CharSequence p2, int p3, int p4, Paint.FontMetricsInt p5) {
		return mTabWidth;
	}

	@Override
	public void draw(Canvas p1, CharSequence p2, int p3, int p4, float p5, int p6, int p7, int p8, Paint p9) {}
}
