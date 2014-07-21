package de.fhdw.bfwi412a.geopfad;

import android.widget.ImageView;
import android.widget.TextView;

public class ActivityLocationsGUI {
	
	ActivityLocations mActLoc;
	TextView mTitle;
	TextView mAbout;
	ImageView mImageUrl;

	public ActivityLocationsGUI(ActivityLocations actloc) {
		mActLoc = actloc;
		mTitle = (TextView) mActLoc.findViewById(R.id.textView1);
		mAbout = (TextView) mActLoc.findViewById(R.id.textView2);
		mImageUrl = (ImageView) mActLoc.findViewById(R.id.imageView1);	
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
	
	
}
