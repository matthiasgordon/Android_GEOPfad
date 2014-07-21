package de.fhdw.bfwi412a.geopfad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class ActivityLocations extends Activity {

	Context context = ActivityLocations.this;
	
	ActivityLocationsData mData;
	ActivityLocationsGUI mGUI;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();

	}
	
	private void initData () {
		mData = new ActivityLocationsData(this);
	}

	private void initGUI () {
		setContentView(R.layout.activity_locations);
		mGUI = new ActivityLocationsGUI(this);
		mGUI.getTitle().setText(mData.getTitel());
		mGUI.getImageUrl().setImageResource(this.getResources()
				.getIdentifier(mData.getImageUrl(), "drawable", this.getPackageName())
				);
	}
	
	private void initApplicationLogic () {
		
	}
	
	private void initEventToListenerMapping () {
		
	}
	
	
}
