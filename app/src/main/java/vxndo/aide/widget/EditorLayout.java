package vxndo.aide.widget;

import android.widget.*;
import android.content.*;
import android.util.*;
import android.view.*;
import android.animation.*;

public class EditorLayout
extends FrameLayout {

	private int preHeight;

	public EditorLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		LayoutParams params = new LayoutParams(-1, -1);
		params.gravity = Gravity.BOTTOM;
		final FrameLayout rootView = new FrameLayout(context);
		rootView.setLayoutParams(params);
		
		final ShortcutView view = new ShortcutView(context);
		view.makeShortcuts(new String[] {"⇥","{","}","(",")",";",",",".","=","\"","|","&","!","[","]"});
		
		final LayoutParams scrollParams = new LayoutParams(-1, -1);
		final ScrollView scrollView = new ScrollView(context);
		scrollView.setLayoutParams(scrollParams);
		scrollView.setFillViewport(true);
		
		HorizontalScrollView hScrollView = new HorizontalScrollView(context);
		hScrollView.setLayoutParams(new LayoutParams(-1, -1));
		hScrollView.setFillViewport(true);
		
		EditorView editorView = new EditorView(context);
		editorView.setLayoutParams(new LayoutParams(-1, -1));
		
		view.link(editorView);
		
		rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				int height = rootView.getHeight();
				if (height != preHeight) {
					LayoutParams params = new LayoutParams(-1, 100);
					params.setMargins(0, height-100, 0, 0);
					view.setLayoutParams(params);
					
					final boolean show = preHeight < height;
					scrollParams.setMargins(0, 0, 0, show ? 0 : 100);
					scrollView.setLayoutParams(scrollParams);
					view.setVisibility(VISIBLE);
					int a = show ? 0 : 1;
					if (show) view.setAlpha(0);
					view.animate().setDuration(200).alpha(a).setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator p1) {
							view.setVisibility(show ? GONE : VISIBLE);
							super.onAnimationEnd(p1);
						}
					}).start();
					preHeight = height;
				}
			}
		});
		
		hScrollView.addView(editorView);
		scrollView.addView(hScrollView);
		rootView.addView(scrollView);
		rootView.addView(view);
		addView(rootView);
	}
}
