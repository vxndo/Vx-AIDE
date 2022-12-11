package vxndo.aide.editor;

import android.graphics.*;
import android.text.style.*;

public class TabSpan extends ReplacementSpan {

	private int tabWidth;
	private boolean showTabLines;

	public TabSpan(CodeEditor editor, int tabSize, boolean showTabLines) {
		tabWidth = Math.round(editor.getPaint().measureText("m") * tabSize);
		this.showTabLines = showTabLines;
	}

	@Override
	public int getSize(Paint p1, CharSequence p2, int p3, int p4, Paint.FontMetricsInt p5) {
		return tabWidth;
	}

	@Override
	public void draw(Canvas p1, CharSequence p2, int p3, int p4, float p5, int p6, int p7, int p8, Paint p9) {
		if (showTabLines) {
			p9.setStrokeWidth(2);
			p9.setColor(0xffffffff);
			p9.setStyle(Paint.Style.FILL);
			p1.drawLine(p5, p7, p5 + tabWidth - tabWidth / 10, p7, p9);
		}
	}
}
