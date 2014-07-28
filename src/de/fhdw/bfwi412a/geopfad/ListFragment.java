package de.fhdw.bfwi412a.geopfad;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListFragment extends Fragment {
	
	ListFragmentData mData;
	ListFragmentGUI mGUI;
	ListFragmentApplicationLogic mAppLogic;
	ListFragmentEventToListenerMapping mEventToListenerMapping;

	public ListFragment () {
		
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View mView = inflater.inflate(R.layout.list_fragment, container, false);
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
}