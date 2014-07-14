package de.fhdw.bfwi412a.geopfad;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentB extends Fragment {

	public FragmentB () {
		
	}
	
	ListView lstitems;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_b, container, false);
		
		lstitems = (ListView) view.findViewById(R.id.listViewMain);
		
		lstitems.setAdapter(new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.dataelements)));
		
		lstitems.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View viewClicked,
					int position, long id) {
				TextView textView = (TextView) viewClicked;
				String message = "Du hast das " + position
						+ ". Item, mit dem Text: " + textView.getText().toString() + " angeklickt.";
				Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
				
			}
		});
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
	}
	
}
