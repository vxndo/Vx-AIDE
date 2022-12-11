package vxndo.aide.editor;

import android.app.*;
import android.os.*;
import android.view.*;
import vxndo.aide.*;
import android.widget.*;

public class CodeEditorFragment extends Fragment {

	CodeEditor codeEditor;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.code_editor_fragment, container);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		codeEditor = view.findViewById(R.id.code_editor_fragment_codeeditor);
	}
}
