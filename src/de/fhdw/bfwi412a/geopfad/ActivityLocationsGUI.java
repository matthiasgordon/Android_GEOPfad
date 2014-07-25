package de.fhdw.bfwi412a.geopfad;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityLocationsGUI {
	
	ActivityLocations mActLoc;
	TextView mTitle;
	TextView mAbout;
	ImageView mImageUrl;
	TextView mVisitText;
	TextView mVisitStatus;
	Button mBtnVisit;
	Button mBtnNavigation;

	public ActivityLocationsGUI(ActivityLocations actloc) {
		mActLoc = actloc;
		mTitle = (TextView) mActLoc.findViewById(R.id.textView1);
		mAbout = (TextView) mActLoc.findViewById(R.id.textView2);
		mImageUrl = (ImageView) mActLoc.findViewById(R.id.imageView1);
		mVisitText = (TextView) mActLoc.findViewById(R.id.txtVisitText);
		mVisitStatus = (TextView) mActLoc.findViewById(R.id.txtVisitStatus);
		mBtnVisit = (Button) mActLoc.findViewById(R.id.btnVisit);
		mBtnNavigation = (Button) mActLoc.findViewById(R.id.btnNavigation);
	}

	public ActivityLocations getActLoc() {
		return mActLoc;
	}

	public TextView getTitle() {
		return mTitle;
	}

	public TextView getAbout() {
		return mAbout;
	}

	public ImageView getImageUrl() {
		return mImageUrl;
	}
	
	public TextView getVisitText() {
		return mVisitText;
	}
	
	public TextView getVisitStatus() {
		return mVisitStatus;
	}
	
	public Button getBtnVisit(){
		return mBtnVisit;
	}

	public Button getBtnNavigation() {
		return mBtnNavigation;
	}
	
	
}
