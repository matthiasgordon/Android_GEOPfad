package de.fhdw.bfwi412a.geopfad;

import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.maps.model.LatLng;

public class MapFragmentData {
	
	private final LatLng LOCATION_GEOPFAD = new LatLng(50.99876752, 7.14546919);
	
	private List <LatLng> mRouteCoordinates = new ArrayList <LatLng> ();
	private List <LatLng> mMarkerCoordinates = new ArrayList <LatLng> ();
	
	public MapFragmentData(){
		mRouteCoordinates = new Coordinates().getCoordinates();
		mMarkerCoordinates.add(LOCATION_GEOPFAD);
	}

	public List<LatLng> getRouteCoordinates() {
		return mRouteCoordinates;
	}

	public List<LatLng> getMarkerCoordinates() {
		return mMarkerCoordinates;
	}
	
}
