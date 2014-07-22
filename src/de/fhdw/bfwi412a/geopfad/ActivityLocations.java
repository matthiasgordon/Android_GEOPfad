package de.fhdw.bfwi412a.geopfad;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityLocations extends Activity {

	Context context = ActivityLocations.this;
	public static final String PREFS_NAME = "MYPrefernceFile";
	ActivityLocationsData mData;
	ActivityLocationsGUI mGUI;
	ActivityLocationsApplicationLogic mAppLogic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();

		Button btnVisit = (Button) findViewById(R.id.btnVisit);
		btnVisit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences visitStatus = getSharedPreferences(PREFS_NAME, 0);
				SharedPreferences.Editor editor = visitStatus.edit();
				editor.putString(mData.mVisitKey, "ja");
				editor.commit();
				mGUI.getVisitStatus().setText(visitStatus.getString(mData.mVisitKey, "Nein"));
			}
		});
	}
	
	private void initData () {
		mData = new ActivityLocationsData(this);
	}

	private void initGUI () {
		setContentView(R.layout.activity_locations);
		mGUI = new ActivityLocationsGUI(this);
		mGUI.getTitle().setText(mData.getTitle());
		mGUI.getImageUrl().setImageResource(this.getResources()
				.getIdentifier(mData.getImageUrl(), "drawable", this.getPackageName())
				);
		mGUI.getAbout().setText(mData.getAbout());
		SharedPreferences visitStatus = getSharedPreferences(PREFS_NAME, 0);
		mGUI.getVisitStatus().setText(visitStatus.getString(mData.mVisitKey, "Nein"));
		
	}
	
	private void initApplicationLogic () {
		mAppLogic = new ActivityLocationsApplicationLogic(this, mData, mGUI);
	}
	
	private void initEventToListenerMapping () {
		new ActivityLocationsEventToListenerMapping(mGUI, mAppLogic);
	}
	
	
}
