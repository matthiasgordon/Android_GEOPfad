package de.fhdw.bfwi412a.geopfad;

import android.content.Intent;

import com.google.android.gms.maps.model.Marker;

public class MapFragmentApplicationLogic {
	
	MapFragmentData mData;
	MapFragmentGUI mGUI;
	
	public MapFragmentApplicationLogic(MapFragmentData data, MapFragmentGUI gui) {
		mData = data;
		mGUI = gui;
	}
	
	public void changeMarkers(int id){
//		mData.
	}
	
	public void onMarkerClicked(Marker mMarker){
		for (Ort curOrt : mData.getOrte()){
			if(curOrt.getName().equals(mMarker.getTitle())){
				Intent intent = new Intent(mData.getActivity(), ActivityLocations.class);
				intent.putExtra("Ortname", curOrt.getName());
				intent.putExtra("imageUrl", curOrt.getImgUrl());
				intent.putExtra("about", curOrt.getAbout());
				mData.getActivity().startActivity(intent);
			}
		}
	}
}