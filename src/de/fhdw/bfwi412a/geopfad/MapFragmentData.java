package de.fhdw.bfwi412a.geopfad;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.model.LatLng;

public class MapFragmentData {
	
	private FragmentActivity mActivity;
	private List <Ort> mOrte;
	private List <LatLng> mRouteCoordinates = new ArrayList <LatLng> ();

	public MapFragmentData(MapFragment mfrag){
		mActivity = mfrag.getActivity();
		mOrte = Orte_DOM_Parser.getOrteFromFile(mActivity);
		mRouteCoordinates = new Coordinates().getCoordinates();
	}
	
	public FragmentActivity getActivity() {
		return mActivity;
	}

	public List<Ort> getOrte() {
		return mOrte;
	}

	public List<LatLng> getRouteCoordinates() {
		return mRouteCoordinates;
	}
}
