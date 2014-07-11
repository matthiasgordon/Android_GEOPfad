package de.fhdw.bfwi412a.geopfad;

import android.app.Activity;
import android.os.Bundle;

public class ActivityLocations extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();
	}
	
	private void initData () {
		
	}

	private void initGUI () {
		setContentView(R.layout.activity_locations);
	}
	
	private void initApplicationLogic () {
		
	}
	
	private void initEventToListenerMapping () {
		
	}
}
