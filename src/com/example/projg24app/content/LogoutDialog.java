package com.example.projg24app.content;

import com.example.projg24app.R;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LogoutDialog extends Dialog {

	private Button btnCheck, btnCancel;
	private Context context;

	public LogoutDialog(final Context context) {
		super(context);
		this.context = context;
		setContentView(R.layout.dialog_logout);

		btnCheck = (Button) findViewById(R.id.btn_logout_ok);
		btnCancel = (Button) findViewById(R.id.btn_logout_cancel);

		btnCancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT);
				dismiss();

			}
		});

		btnCheck.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Toast.makeText(context, "Check", Toast.LENGTH_SHORT);
				dismiss();
			}
		});
	}

}
