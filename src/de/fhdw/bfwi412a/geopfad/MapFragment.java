package de.fhdw.bfwi412a.geopfad;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MapFragment extends Fragment {
	
	MapFragmentData mData;
	MapFragmentGUI mGUI;
	MapFragmentApplicationLogic mApplicationLogic;
	
	public MapFragment () {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View mView = inflater.inflate(R.layout.mapfragment, container, false);
		initData();
		initGUI(mView);
		initApplicationLogic();
		initEventToListenerMapping();
		return mView;
	}	

	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		initData();
//		initGUI();
//		initApplicationLogic();
//		initEventToListenerMapping();
//	
	}
	
	private void initData () {
		mData = new MapFragmentData();
	}

	private void initGUI (View view) {
		mGUI = new MapFragmentGUI(this, view);
		mGUI.styleMap(mData.getRouteCoordinates(), mData.getMarkerCoordinates());
	}
	
	private void initApplicationLogic () {
		mApplicationLogic = new MapFragmentApplicationLogic(mData, mGUI);
	}
	
	private void initEventToListenerMapping () {
//		new MapFragmentEventToListener(mApplicationLogic, mGUI);
	}
}