package com.example.projg24app.content.slidedrawer;

import com.example.projg24app.ContentActivity;
import com.example.projg24app.R;
import com.example.projg24app.TheNewsActivity;
import com.example.projg24app.fragment.MenuFragment;
import com.example.projg24app.fragment.TestFragment;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SlideDrawerContentLeftListFragment extends ListFragment {

	String[] presidents = { "最新消息", "探索活動", "我的最愛", "近期檢視", "登出" };

	// MY_PROFILE = "個人檔案",
	// THE_NEWS = "最新消息",
	// SEARCH_EXHIBITION = "探索活動",
	// MY_FAVORITE = "我的最愛",
	// NEAR_INSPECT = "近期檢視",
	// LOGOUT = "登出";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, presidents));
	}

	public void onListItemClick(ListView parent, View v, int position, long id) {
		Toast.makeText(getActivity(), "您選擇項目是 : " + presidents[position],
				Toast.LENGTH_SHORT).show();
		// Intent intent = new Intent(getActivity(),TheNewsActivity.class);
		// startActivity(intent);

		// Fragment f2;
		//
		// FragmentManager manager ;
		//
		// manager= getActivity().getSupportFragmentManager() ;
		//
		// FragmentTransaction transaction = manager.beginTransaction() ;
		//
		// f2 = new Fragment2();
		//
		// transaction = manager.beginTransaction();
		//
		// transaction.replace(R.id.fragment_container,f2);
		//
		// transaction.commit();

		if (getActivity() instanceof ContentActivity) {
			// HashMap<String, Object> map = (HashMap<String, Object>)
			// parent.getItemAtPosition(position);
			// int i = (Integer) map.get("itemId");
			Fragment frag = getFragment(2);// 获取对应页面的Fragment
			((ContentActivity) getActivity()).switchContent(frag);// (frag);
		}

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.content_left_list_fragment_layout,container, false);
	}

	public Fragment getFragment(int i) {
		switch (i) {
		case 1:
			return new TestFragment();

		case 2:
			return new MenuFragment();

		}
		return null;
	}

}
