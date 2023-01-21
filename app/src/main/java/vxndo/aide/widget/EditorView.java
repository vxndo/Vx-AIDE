package vxndo.aide.widget;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;
import vxndo.aide.widget.text.*;

public class EditorView
extends MultiAutoCompleteTextView {

	private EditorWatcher mWatcher;

	public EditorView(Context context) {
		super(context);
		setGravity(Gravity.TOP);
		setTypeface(Typeface.MONOSPACE);
		setHorizontallyScrolling(true);
		setBackgroundColor(0xFF303030);
		setTextColor(0xFFAAB6C6);
		mWatcher = new EditorWatcher();
		mWatcher.setTabWidth((int)getPaint().measureText("m")*4);
		addTextChangedListener(mWatcher);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Integer baseline, lineNumber = 1;
		Integer textWidth = (int) getPaint().measureText("m");
		Integer lineWidth = (int) getPaint().measureText(String.valueOf(getLineCount()));
		RectF bgRect = new RectF(0, 0, lineWidth+textWidth, getHeight()+getScrollY());
		RectF lineRect = new RectF(lineWidth+textWidth, 0, lineWidth+textWidth+2, getHeight()+getScrollY());
		Paint bgPaint = new Paint(), linePaint = new Paint(), textPaint = new Paint();
		textPaint.set(getPaint());
		textPaint.setTextAlign(Paint.Align.RIGHT);
		bgPaint.setColor(0xFF343638);
		linePaint.setColor(0xFFAAB6C6);
		canvas.drawRect(bgRect, bgPaint);
		canvas.drawRect(lineRect, linePaint);
		for (int i = 0; i < getLineCount(); ++i) {
			baseline = getLineBounds(i, null);
			if (i == 0) {
				canvas.drawText(lineNumber.toString(), lineRect.left-textWidth/2, baseline, textPaint);
				++lineNumber;
			} else if (getText().charAt(getLayout().getLineStart(i) - 1) == '\n') {
				canvas.drawText(lineNumber.toString(), lineRect.left-textWidth/2, baseline, textPaint);
				++lineNumber;
			}
		} setPaddingLeft(lineWidth+textWidth+(textWidth/2));
		super.onDraw(canvas);
	}

	@Override
	protected void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
		super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
		if (horiz > oldHoriz || vert > oldVert) {
			requestLayout();
		}
	}

	private void invalidateVisibleArea() {
		int bottom = (getScrollY() + getPaddingTop()) + getHeight();
        invalidate(getPaddingLeft(), getScrollY() + getPaddingTop(), getWidth(), bottom);
    }

	public void setPaddingLeft(int paddingLeft) {
		if (paddingLeft == getPaddingLeft()) return;
		setPadding(paddingLeft, getPaddingTop(), getPaddingRight(), getPaddingBottom());
	}
}
