package vxndo.aide.editor;

import android.text.*;

public class CodeEditorWatcher implements TextWatcher {

	private CodeEditor editor;
	private int tabSize, start, count;
	private boolean showTabLines, wordWrap;

	public CodeEditorWatcher(CodeEditor editor) {
		this.editor = editor;
		tabSize = 4;
		showTabLines = true;
		wordWrap = true;
	}

	@Override
	public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4) {
		// TODO: Implement this method
	}

	@Override
	public void onTextChanged(CharSequence p1, int p2, int p3, int p4) {
		start = p2;
		count = p4;
	}

	@Override
	public void afterTextChanged(Editable p1) {
		if (!wordWrap) editor.setMaxLines(editor.getLineCount());
		String s = p1.toString();
		for (int stop = start + count; (start = s.indexOf("\t", start)) > -1 && start < stop; ++start) {
			p1.setSpan(new TabSpan(editor, tabSize, showTabLines),start,start+1,33);
		}
	}
}
