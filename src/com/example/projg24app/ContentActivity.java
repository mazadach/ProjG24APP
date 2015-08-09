package com.example.projg24app;

import java.util.ArrayList;

import com.example.projg24app.content.slidedrawer.SlideDrawerAdapter;
import com.example.projg24app.content.slidedrawer.SlideDrawerContentLeftListFragment;
import com.example.projg24app.content.slidedrawer.SlideDrawerModel;
import com.example.projg24app.fragment.TestFragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.Fragment;

public class ContentActivity extends Activity {

	// private ListView drawerListView;
	//private Button btntest;
	private ActionBarDrawerToggle mDrawerToggle;
	private String mTitle = "";
	private DrawerLayout drawerLayout;
	private ArrayList<SlideDrawerModel> arrayList;
	private SlideDrawerAdapter leftListadapter;
	 FragmentManager fragmentManager = getFragmentManager();
	SlideDrawerContentLeftListFragment rFragment;
	Fragment testFragment;

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
		
		 FragmentTransaction ft = fragmentManager.beginTransaction();
		 ft.replace(R.id.drawer_list, rFragment);
		 ft.commit();
		 
		  testFragment = new TestFragment();
		 
		 FragmentTransaction testft = fragmentManager.beginTransaction();
		 testft.replace(R.id.content_frame, testFragment);
		 testft.commit();
		
		
		findView();
		setView();
		
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

	  public void switchContent(Fragment from, Fragment to) {
	        if (testFragment != to) {
	        	testFragment = to;
	            FragmentTransaction transaction = fragmentManager.beginTransaction();
	            if (!to.isAdded()) {    // 先判断是否被add过
	                transaction.hide(from).add(R.id.content_frame, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
	            } else {
	                transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
	            }
	        }
	    }

	  public void switchContent(Fragment fragment) {
	        if(testFragment != fragment) {
	        	FragmentTransaction ft = fragmentManager.beginTransaction();  
	        	testFragment = fragment;
		        ft.replace(R.id.content_frame, testFragment);  
		        ft.addToBackStack(null);  
		        ft.commit();  
	        }
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