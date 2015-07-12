package com.example.projg24app.content.slidedrawer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.projg24app.ContentActivity;
import com.example.projg24app.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;




public class SlideDrawerContentMainFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
	
		// Retrieving the currently selected item number
		int position = getArguments().getInt("position");
		
		// List of rivers
		String[] rivers = getResources().getStringArray(R.array.rivers);
		
		// Creating view correspoding to the fragment
		View v = inflater.inflate(R.layout.content_main_fragment_layout, container, false);
		
		// Getting reference to the TextView of the Fragment
		TextView tv = (TextView) v.findViewById(R.id.tv_content);
		
		// Setting currently selected river name in the TextView
		tv.setText(rivers[position]);		
		
		// Updating the action bar title
		getActivity().getActionBar().setTitle(rivers[position]);
		
		return v;
	}
}