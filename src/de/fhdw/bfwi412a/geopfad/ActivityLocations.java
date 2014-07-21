package de.fhdw.bfwi412a.geopfad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityLocations extends Activity {

	Context context = ActivityLocations.this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();
	
		setBundle();
	}
	
	private void initData () {
		
	}

	private void initGUI () {
		setContentView(R.layout.activity_locations);
	}
	
	private void initApplicationLogic () {
		
	}
	
	private void initEventToListenerMapping () {
		
	}
	
	private void setBundle(){
		Bundle ortInfo = getIntent().getExtras();
		String ortName = ortInfo.getString("Ortname");
		String ortImageUrl = ortInfo.getString("imageUrl");
		String ortAbout = ortInfo.getString("about");
		
		TextView txtOrtName = (TextView)findViewById(R.id.textView1);
		txtOrtName.setText(ortName);
		
		TextView txtOrtAbout = (TextView)findViewById(R.id.textView2);
		txtOrtAbout.setText(ortAbout);
		
		int id = getResources().getIdentifier(ortImageUrl, "drawable", getPackageName());
		ImageView imageUrl = (ImageView)findViewById(R.id.imageView1);
		imageUrl.setImageResource(id);
	}
}
