package de.fhdw.bfwi412a.geopfad;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class FragmentA extends Fragment {
	
	private final LatLng LOCATION_GEOPFAD = new LatLng(50.99876752, 7.14546919);
	
	SupportMapFragment mFragment;
	GoogleMap mMap;
	
	public FragmentA () {
		
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View mView = inflater.inflate(R.layout.fragment_a, container, false);
		
		FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
		
		if(mFragment == null){
			mFragment = (SupportMapFragment) mFragmentManager.findFragmentById(R.id.map);
		}
		
		mMap = mFragment.getMap();
		mMap.addPolyline(new PolylineOptions()
					.addAll(new Coordinates().getCoordinates())
					.width(8));
		mMap.addMarker(new MarkerOptions().position(LOCATION_GEOPFAD).title("Mitte der Karte!"));
		mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_GEOPFAD, 14));
		mMap.setMyLocationEnabled(true);
		return mView;
	}
}
