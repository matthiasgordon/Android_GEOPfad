package de.fhdw.bfwi412a.geopfad;

import java.util.List;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapFragmentGUI {
	
	SupportMapFragment mFragment;
	GoogleMap mMap;
	Spinner mSpinner;
	
	MapFragmentGUI(MapFragment mfrag, View view){
		FragmentManager mFragmentManager = mfrag.getActivity().getSupportFragmentManager();
		if(mFragment == null){
			mFragment = (SupportMapFragment) mFragmentManager.findFragmentById(R.id.map);
		}
		mMap = mFragment.getMap();
		mSpinner = (Spinner) view.findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(mfrag.getActivity(),
		R.array.string_spinner, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpinner.setAdapter(adapter);
	}

	public GoogleMap getMap() {
		return mMap;
	}

	public Spinner getSpinner() {
		return mSpinner;
	}

	public void styleMap(List <LatLng> mRouteCoordinates, List <LatLng> mMarkerCoordinates){
		if(mMap != null){
			mMap.addPolyline(new PolylineOptions()
			.addAll(mRouteCoordinates)
			.width(8));
			for (LatLng mCoordinate : mMarkerCoordinates){
				mMap.addMarker(new MarkerOptions().position(mCoordinate).title("Mitte der Karte!"));	
			}
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(50.99876752, 7.14546919), 14));
			mMap.setMyLocationEnabled(true);
		}
	}
	
}
