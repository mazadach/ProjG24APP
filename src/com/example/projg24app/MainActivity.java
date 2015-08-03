package com.example.projg24app;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {
	private Animation animation = null;
	private ImageView  imageView = null;
	private TextView textView;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_welcome);
		welcomeView();
		findView();
		setView();
		setAction();
	}
	private void findView(){
		
	}
	private void setView(){
		
	}
	
	private void setAction(){
	
		
	}
	
	private void welcomeView(){
		imageView = (ImageView)findViewById(R.id.iv_welcome);
		textView = (TextView)findViewById(R.id.tv_welcome);
		animation = AnimationUtils.loadAnimation(this, R.anim.welcome_alpha);
		animation.setFillEnabled(true); //启動Fill保持
		animation.setFillAfter(true);  //設置動畫的最後一幀是保持在View上面
		imageView.setAnimation(animation);
		textView.setAnimation(animation);
		animation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				Intent intent = new Intent(MainActivity.this,LoginActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.a2,R.anim.a1);
				finish();
			}
		});
		
	}
	
	
	
	

}
