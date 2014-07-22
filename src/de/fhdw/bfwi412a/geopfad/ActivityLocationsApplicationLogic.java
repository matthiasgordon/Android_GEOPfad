package de.fhdw.bfwi412a.geopfad;

import android.content.Intent;
import android.net.Uri;

public class ActivityLocationsApplicationLogic {
	
	private ActivityLocationsData mData;
	private ActivityLocationsGUI mGUI;
	ActivityLocations mActivity;

	public ActivityLocationsApplicationLogic(ActivityLocations act, 
			ActivityLocationsData data, ActivityLocationsGUI gui) {
		mData = data;
		mGUI = gui;
		mActivity = act;
	}
	
	public void navigateToLocation(){
		double mLat = mData.getmLatitude();
		double mLng = mData.getmLongitude();
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
				 Uri.parse("google.navigation:q=" + mLat + "," + mLng));
		mActivity.startActivity(intent);
	}
}
