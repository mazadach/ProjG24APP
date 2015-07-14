package com.example.projg24app;

import java.util.ArrayList;

import com.example.projg24app.content.slidedrawer.SlideDrawerAdapter;
import com.example.projg24app.content.slidedrawer.SlideDrawerContentLeftListFragment;
import com.example.projg24app.content.slidedrawer.SlideDrawerContentMainFragment;
import com.example.projg24app.content.slidedrawer.SlideDrawerModel;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ContentActivity extends Activity {

	// private ListView drawerListView;
	private Button btntest;
	private ActionBarDrawerToggle mDrawerToggle;
	private String mTitle = "";
	private DrawerLayout drawerLayout;
	private ArrayList<SlideDrawerModel> arrayList;
	private SlideDrawerAdapter leftListadapter;

	public static final String MY_PROFILE = "個人檔案", THE_NEWS = "最新消息",
			SEARCH_EXHIBITION = "探索活動", MY_FAVORITE = "我的最愛",
			NEAR_INSPECT = "近期檢視", LOGOUT = "登出";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		findView();
		setView();
		setAction();
	}

	private void findView() {
		mTitle = (String) getTitle();
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		btntest = (Button) findViewById(R.id.drawer_list);
	}

	private void setView() {
		mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			/** Called when drawer is closed */
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu();

			}

			/** Called when a drawer is opened */
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle("Select a river");
				invalidateOptionsMenu();
			}

		};

		drawerLayout.setDrawerListener(mDrawerToggle);

		// arrayList=new ArrayList<SlideDrawerModel>();
		//
		// arrayList.add(new SlideDrawerModel(R.drawable.ic_btn, MY_PROFILE));
		// arrayList.add(new SlideDrawerModel(R.drawable.ic_btn, THE_NEWS));
		// arrayList.add(new SlideDrawerModel(R.drawable.ic_btn,
		// SEARCH_EXHIBITION));
		// arrayList.add(new SlideDrawerModel(R.drawable.ic_btn, MY_FAVORITE));
		// arrayList.add(new SlideDrawerModel(R.drawable.ic_btn, NEAR_INSPECT));
		// arrayList.add(new SlideDrawerModel(R.drawable.ic_btn, LOGOUT));
		//
		// leftListadapter = new SlideDrawerAdapter(getBaseContext(),
		// arrayList);

		// drawerListView.setAdapter(leftListadapter);

		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		// drawerListView.setOnItemClickListener(new OnItemClickListener() {
		//
		// @Override
		// public void onItemClick(AdapterView<?> parent, View view,int
		// position, long id) {
		// // selectItem(position);
		//
		// }
		// });
	}

	private void selectItem(int position) {
		// SlideDrawerContentMainFragment rFragment = new
		// SlideDrawerContentMainFragment();
		// Bundle data = new Bundle();
		// data.putInt("position", position);
		// rFragment.setArguments(data);
		// FragmentManager fragmentManager = getFragmentManager();
		// FragmentTransaction ft = fragmentManager.beginTransaction();
//		 ft.replace(R.id.content_frame, rFragment);
		// ft.commit();
		// drawerLayout.closeDrawer(drawerListView);

	}

	private void setAction() {

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	/** Handling the touch event of app icon */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			
			Log.i("msg","open_item");
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/** Called whenever we call invalidateOptionsMenu() */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean drawerOpen = drawerLayout.isDrawerOpen(btntest);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
//		SlideDrawerContentLeftListFragment fragment1 = new SlideDrawerContentLeftListFragment();  
//         getFragmentManager().beginTransaction().replace(R.id.main_layout, fragment1).commit();  
		
		Log.i("msg","open");
		
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		Log.i("msg","open_menu");
		return true;
	}
}