package com.example.projg24app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity {

	private Button btnLogin;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		overridePendingTransition(R.anim.a2, R.anim.a1);
		findView();
		setView();
		setAction();
	}

	private void findView() {
		btnLogin = (Button) findViewById(R.id.btn_main_login);

	}

	private void setView() {

	}

	private void setAction() {
		btnLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this,ContentActivity.class);
				startActivity(intent);
			}
		});

	}

}
