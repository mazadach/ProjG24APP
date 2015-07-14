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
	//private Button btntest;
	private ActionBarDrawerToggle mDrawerToggle;
	private String mTitle = "";
	private DrawerLayout drawerLayout;
	private ArrayList<SlideDrawerModel> arrayList;
	private SlideDrawerAdapter leftListadapter;
	SlideDrawerContentLeftListFragment rFragment;

	public static final String 
					MY_PROFILE = "個人檔案", 
					THE_NEWS = "最新消息",
					SEARCH_EXHIBITION = "探索活動", 
					MY_FAVORITE = "我的最愛",
					NEAR_INSPECT = "近期檢視", 
					LOGOUT = "登出";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		
		 rFragment = new SlideDrawerContentLeftListFragment();
		 FragmentManager fragmentManager = getFragmentManager();
		 FragmentTransaction ft = fragmentManager.beginTransaction();
		 ft.replace(R.id.drawer_list, rFragment);
		 ft.commit();
		
		
		findView();
		setView();
		setAction();
	}

	private void findView() {
		mTitle = (String) getTitle();
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
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
				//getActionBar().setTitle("");
				invalidateOptionsMenu();
			}

		};

		drawerLayout.setDrawerListener(mDrawerToggle);

		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
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
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/** Called whenever we call invalidateOptionsMenu() */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean drawerOpen = drawerLayout.isDrawerOpen(R.id.drawer_list);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}