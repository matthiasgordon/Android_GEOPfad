package de.fhdw.bfwi412a.geopfad;

import android.view.View;
import android.widget.ListView;

public class ListFragmentGUI {
	
	private ListView mListOrte;
	private OrteAdapter ortAdapter;
	
	ListFragmentData mData;
	
	public ListFragmentGUI(View mView, ListFragmentData data) {
		mData = data;
		ortAdapter = new OrteAdapter(mView.getContext(), R.layout.list_item, mData.getOrte());
		mListOrte = (ListView) mView.findViewById(R.id.listViewOrte);
		mListOrte.setAdapter(ortAdapter);
	}

	public ListView getListOrte() {
		return mListOrte;
	}
	
}