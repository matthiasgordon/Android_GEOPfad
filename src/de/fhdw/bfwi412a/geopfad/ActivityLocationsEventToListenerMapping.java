package de.fhdw.bfwi412a.geopfad;

import android.view.View;
import android.view.View.OnClickListener;

public class ActivityLocationsEventToListenerMapping implements OnClickListener {

	private ActivityLocationsGUI mGUI;
	private ActivityLocationsApplicationLogic mAppLogic;
	
	public ActivityLocationsEventToListenerMapping(ActivityLocationsGUI gui, ActivityLocationsApplicationLogic appLogic) {
		mGUI = gui;
		mAppLogic = appLogic;
		mGUI.getBtnNavigation().setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		mAppLogic.navigateToLocation();
	}

}
