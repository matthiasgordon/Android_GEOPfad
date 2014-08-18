package de.fhdw.bfwi412a.geopfad;

import android.widget.Button;

public class ActivityStartGUI {

	Button mToActivityMainButton;
	
	public ActivityStartGUI(ActivityStart act) {
		mToActivityMainButton = (Button) act.findViewById(R.id.ToActivityMainButton);
	}

	public Button getToActivityMainButton() {
		return mToActivityMainButton;
	}
	
	
	
}
