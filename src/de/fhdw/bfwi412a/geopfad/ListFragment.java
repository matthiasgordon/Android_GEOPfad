package de.fhdw.bfwi412a.geopfad;


import java.util.ArrayList;
import java.util.List;

import android.content.*;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListFragment extends Fragment {

	public ListFragment () {
		
	}
	
	ListView lstitems;
	private OrteAdapter ortAdapter;
	private ListView listOrte;
	Context context = this.getActivity();
	List<Ort> orte;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_b, container, false);
		
		listOrte = (ListView) view.findViewById(R.id.listViewOrte);
	    orte = Orte_DOM_Parser.getOrteFromFile(this.getActivity());
	        
	    ortAdapter = new OrteAdapter(view.getContext(), R.layout.list_item, orte);
	    listOrte.setAdapter(ortAdapter);
		
		listOrte.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View viewClicked,
					int position, long id) {
				
				String ortName = orte.get(position).getName().toString();
				String ortImage = orte.get(position).getImgUrl();
				String about = orte.get(position).getAbout();
				double latitude = orte.get(position).getLat();
				double longitude = orte.get(position).getLng();
				String visitKey = orte.get(position).getVisitKey();
				/*Wenn ein Ort des ListViews angetippt wird, führt dies zur ActivityLocation*/
				Intent newActivity = new Intent(getActivity(), ActivityLocations.class);
				newActivity.putExtra("Ortname", ortName);
				newActivity.putExtra("imageUrl", ortImage);
				newActivity.putExtra("about", about);
				newActivity.putExtra("latitude", latitude);
				newActivity.putExtra("longitude", longitude);
				newActivity.putExtra("visitKey", visitKey);
			
				startActivity(newActivity);
				
				
			}
		});
		return view;
	}
	
	public class Item {
		
		 private String text; //Das ist der Text der in der Liste angezeigt wird
		 private String info;
		
		 public Item(String text,String info){
		 this.text = text;
		 this.info = info;
		 }
		
		 public String getText(){
		 return text;
		 }
		
		 public String getInfo(){
		 return info;
		 }
		
	};
	
	public class ItemAdapter extends BaseAdapter {
		
		 private int layout;
		 private ArrayList<Item> listOfItems;
		 private Context context;
		
		 public ItemAdapter(Context context,int layout,ArrayList<Item> listOfItems){
		 super();
		 this.context = context;
		 this.layout = layout;
		 this.listOfItems = listOfItems;
		 }
		
		 @Override
		 public int getCount() {
		 return listOfItems.size();
		 }
		
		 @Override
		 public Object getItem(int position) {
		 return listOfItems.get(position);
		 }
		
		 @Override
		 public long getItemId(int position) {
		 return position;
		 }
		
		 @Override
		 public View getView(int position, View convertView, ViewGroup parent) {
		
		 TextView textView;
		
		 if (convertView == null){
		 textView = (TextView) LayoutInflater.from(context).inflate(layout,parent,false);
		 }else{
		 textView = (TextView) convertView; //View wiedervenden
		 }
		
		 textView.setText(listOfItems.get(position).getText()); //Hier den Text aus dem Objekt verwenden
		
		 return textView;
		
		 }
		
		}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
	}
	
}
