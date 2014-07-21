package de.fhdw.bfwi412a.geopfad;

import android.os.Bundle;

public class ActivityLocationsData {
	
	ActivityLocations mActivity;
	Bundle mOrtInfo;
	String mTitel;
	String mImageUrl;
	String mAbout;
	
	public ActivityLocationsData(ActivityLocations actLocations) {
		mActivity = actLocations;
		mOrtInfo = mActivity.getIntent().getExtras();
		mTitel = mOrtInfo.getString("Ortname");
		mImageUrl = mOrtInfo.getString("imageUrl");
		mAbout = mOrtInfo.getString("about");
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

	public String getTitel() {
		return mTitel;
	}

	public void setTitel(String mTitel) {
		this.mTitel = mTitel;
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
}
