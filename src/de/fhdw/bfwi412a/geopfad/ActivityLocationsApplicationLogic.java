package de.fhdw.bfwi412a.geopfad;

import android.content.Intent;
import android.content.SharedPreferences;
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
		double mLat = mData.getLatitude();
		double mLng = mData.getLongitude();
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
				 Uri.parse("google.navigation:q=" + mLat + "," + mLng));
		mActivity.startActivity(intent);
	}
	
	public void changeVisitStatus(){
		SharedPreferences visitStatus = mData.getVisitStatus();
		SharedPreferences.Editor editor = visitStatus.edit();
		
		if(visitStatus.getString(mData.getVisitKey(), "nein").equals("nein")){
			editor.putString(mData.mVisitKey, "ja");
			editor.commit();
		}
		else{
			editor.putString(mData.mVisitKey, "nein");
			editor.commit();
		}
		mGUI.getVisitStatus().setText(visitStatus.getString(mData.mVisitKey, "Nein"));
	}
}
