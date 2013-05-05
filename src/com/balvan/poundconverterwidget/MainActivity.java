package com.balvan.poundconverterwidget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends Activity {

	// TAG for logger
	static final String TAG = "PoundConverter.MainActivity";

	TextWatcher watcherPound;
	TextWatcher watcherKg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText kgTxt = ((EditText) findViewById(R.id.kgTxt));
		final EditText poundTxt = ((EditText) findViewById(R.id.poundTxt));

		watcherKg = new TextWatcher() {

			public void afterTextChanged(Editable s) {
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				String poundStr = PoundKgConverter.convertKg2Pound(s);
				if (poundStr==null)
					return;
				if (poundStr.equals(poundTxt.getText().toString())) {
					return;
				}
				poundTxt.removeTextChangedListener(watcherPound);
				poundTxt.setText(poundStr);
				poundTxt.addTextChangedListener(watcherPound);
			}
		};

		watcherPound = new TextWatcher() {

			public void afterTextChanged(Editable s) {
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				String kgStr = PoundKgConverter.convertPound2Kg(s);
				if (kgStr==null)
					return;
				kgTxt.removeTextChangedListener(watcherKg);
				kgTxt.setText(kgStr);
				kgTxt.addTextChangedListener(watcherKg);
			}
		};

		kgTxt.addTextChangedListener(watcherKg);
		poundTxt.addTextChangedListener(watcherPound);
		
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(poundTxt, InputMethodManager.SHOW_IMPLICIT);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
