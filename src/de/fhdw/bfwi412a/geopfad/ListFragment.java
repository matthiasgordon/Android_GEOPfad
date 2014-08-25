package de.fhdw.bfwi412a.geopfad;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;

public class ListFragment extends Fragment {
	
	static final int requestCode = 100;
	

	ListFragmentData mData;
	ListFragmentGUI mGUI;
	ListFragmentApplicationLogic mAppLogic;
	ListFragmentEventToListenerMapping mEventToListenerMapping;

	public ListFragment () {
		
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View mView = inflater.inflate(R.layout.list_fragment, container, false);
		setHasOptionsMenu(true);
		initData();
		initGUI(mView);
		initApplicationLogic();
		initEventToListenerMapping();
		return mView;
	}

	private void initData() {
		mData = new ListFragmentData(this);
	}
	
	private void initGUI(View mView) {
		mGUI = new ListFragmentGUI(mView, mData);
	}
	
	private void initApplicationLogic() {
		mAppLogic = new ListFragmentApplicationLogic(mData, mGUI);
	}
	
	private void initEventToListenerMapping() {
		mEventToListenerMapping = new ListFragmentEventToListenerMapping(mGUI, mAppLogic);
	}

	public void addLocation() {
		Intent intent = new Intent(getActivity(), AddLocation.class);
		startActivityForResult(intent, requestCode);
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		inflater.inflate(R.menu.location_actionbar_menu, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.addLocation:
	            addLocation();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		 if (resultCode == 0 && requestCode == ListFragment.requestCode) {
			
		 }
		
	}
}