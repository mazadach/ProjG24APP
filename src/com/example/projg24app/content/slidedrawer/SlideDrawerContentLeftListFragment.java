package com.example.projg24app.content.slidedrawer;

import com.example.projg24app.R;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SlideDrawerContentLeftListFragment extends ListFragment{
	
	  String[] presidents = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };

	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, presidents));
	    }

	    public void onListItemClick(ListView parent, View v, int position, long id) {
	        Toast.makeText(getActivity(), "您選擇項目是 : " + presidents[position], Toast.LENGTH_SHORT).show();
	    }

	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	        return inflater.inflate(R.layout.testlist, container, false);
	    }

}
