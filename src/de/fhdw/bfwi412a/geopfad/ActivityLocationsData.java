package de.fhdw.bfwi412a.geopfad;

import android.os.Bundle;

public class ActivityLocationsData {
	
	ActivityLocations mActivity;
	Bundle mOrtInfo;
	String mTitle;
	String mImageUrl;
	String mAbout;
	double mLatitude;
	double mLongitude;
	final String mVisitKey;
	
	public ActivityLocationsData(ActivityLocations actLocations) {
		mActivity = actLocations;
		mOrtInfo = mActivity.getIntent().getExtras();
		mTitle = mOrtInfo.getString("Ortname");
		mImageUrl = mOrtInfo.getString("imageUrl");
		mAbout = mOrtInfo.getString("about");
		mVisitKey = mOrtInfo.getString("visitKey");
		mLatitude = mOrtInfo.getDouble("latitude");
		mLongitude = mOrtInfo.getDouble("longitude");
	}

	public ActivityLocations getActivity() {
		return mActivity;
	}

	public void setActivity(ActivityLocations mActivity) {
		this.mActivity = mActivity;
	}

	public Bundle getOrtInfo() {
		return mOrtInfo;
	}

	public void setOrtInfo(Bundle mOrtInfo) {
		this.mOrtInfo = mOrtInfo;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String mTitel) {
		this.mTitle = mTitel;
	}

	public String getImageUrl() {
		return mImageUrl;
	}

	public void setImageUrl(String mImageUrl) {
		this.mImageUrl = mImageUrl;
	}

	public String getAbout() {
		return mAbout;
	}

	public void setAbout(String mAbout) {
		this.mAbout = mAbout;
	}
	
	public String getVisitKey() {
		return mVisitKey;
	}

	public double getmLatitude() {
		return mLatitude;
	}

	public void setmLatitude(double mLatitude) {
		this.mLatitude = mLatitude;
	}

	public double getmLongitude() {
		return mLongitude;
	}

	public void setmLongitude(double mLongitude) {
		this.mLongitude = mLongitude;
	}
	
}
