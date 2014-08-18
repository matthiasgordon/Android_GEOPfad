package de.fhdw.bfwi412a.geopfad;

import android.app.Activity;
import android.os.Bundle;

public class ActivityStart extends Activity {
	
	private ActivityStartData mData;
	private ActivityStartGUI mGUI;
	private ActivityStartApplicationLogic mAppLogic;
	
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		initData();
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();	
	}

	private void initData() {
		mData = new ActivityStartData(this);
	}
	
	private void initGUI() {
		setContentView(R.layout.activity_start);
		mGUI = new ActivityStartGUI(this);
	}
	
	private void initApplicationLogic() {
		mAppLogic = new ActivityStartApplicationLogic(mGUI,mData);
	}
	
	private void initEventToListenerMapping() {
		new ActivityStartEventToListenerMapping(mGUI, mAppLogic);
	}

}
