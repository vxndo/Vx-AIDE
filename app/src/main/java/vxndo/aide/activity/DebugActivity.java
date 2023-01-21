package vxndo.aide.activity;

import android.app.*;
import android.content.*;
import android.os.*;
import java.io.*;

public class DebugActivity extends Activity {

	private String[] exceptionType = {
			"StringIndexOutOfBoundsException",
			"IndexOutOfBoundsException",
			"ArithmeticException",
			"NumberFormatException",
			"ActivityNotFoundException"
	};
	private String[] errMessage= {
			"Invalid string operation\n",
			"Invalid list operation\n",
			"Invalid arithmetical operation\n",
			"Invalid toNumber block operation\n",
			"Invalid intent operation"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		String errMsg = "";
		String madeErrMsg = "";
		if(intent != null){
			errMsg = intent.getStringExtra("error");
			String[] spilt = errMsg.split("\n");
			try {
				for (int j = 0; j < exceptionType.length; j++) {
					if (spilt[0].contains(exceptionType[j])) {
						madeErrMsg = errMessage[j];
						int addIndex = spilt[0].indexOf(exceptionType[j]) + exceptionType[j].length();
						madeErrMsg += spilt[0].substring(addIndex, spilt[0].length());
						break;
					}
				}
				if(madeErrMsg.isEmpty()) madeErrMsg = errMsg;
			}catch(Exception e){}
		} new AlertDialog.Builder(this).
		setTitle("An error occured").
		setMessage(madeErrMsg).
		setNeutralButton("End Application", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		}).show();
	}
}