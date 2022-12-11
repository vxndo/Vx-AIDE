package vxndo.aide.editor;

import android.content.*;
import android.graphics.*;
import android.text.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import vxndo.aide.*;

public class CodeEditor extends EditText {

	private CodeEditorWatcher watcher;

	public CodeEditor(Context context, AttributeSet attr) {
		super(context, attr);
		setPaddingRelative(10, 0, 10, 0);
		setTypeface(Typeface.MONOSPACE);
		setImeOptions(InputType.TYPE_TEXT_FLAG_MULTI_LINE|InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
		setGravity(Gravity.TOP);
		setBackground(null);
		watcher = new CodeEditorWatcher(this);
		addTextChangedListener(watcher);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		int baseline, lineNumber = 1;
		int textWidth = (int) getPaint().measureText("m");
		int lineWidth = (int) getPaint().measureText(String.valueOf(getLineCount()));
		RectF bgRect = new RectF(0, 0, lineWidth+textWidth, getMeasuredHeight());
		RectF bgLineRect = new RectF(lineWidth+textWidth, 0, lineWidth+textWidth+2, getMeasuredHeight());
		Paint bgPaint = new Paint(), bgLinePaint = new Paint();
		bgPaint.setColor(getContext().getColor(R.color.colorSecondary));
		bgLinePaint.setColor(getContext().getColor(R.color.colorDivider));
		canvas.drawRect(bgRect, bgPaint);
		canvas.drawRect(bgLineRect, bgLinePaint);
		for (int i = 0; i < getLineCount(); ++i) {
			baseline = getLineBounds(i, null);
			if (i == 0) {
				canvas.drawText(""+lineNumber, textWidth/2, baseline, getPaint());
				++lineNumber;
			} else if (getText().charAt(getLayout().getLineStart(i) - 1) == '\n') {
				canvas.drawText(""+lineNumber, textWidth/2, baseline, getPaint());
				++lineNumber;
			}
		} setPaddingLeft(lineWidth+textWidth+(textWidth/2));
		super.onDraw(canvas);
	}

	public void setPaddingLeft(int paddingLeft) {
		if (paddingLeft == getPaddingLeft()) return;
		setPadding(paddingLeft, getPaddingTop(), getPaddingRight(), getPaddingBottom());
	}
}
