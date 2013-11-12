package truongtvd.baopinfunny;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;

public class SplashActivity extends Activity {
	ProgressDialog progressBar;

	private Handler progressBarHandler = new Handler();
	private int SWITCH_TIME = 1000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		progressBar = new ProgressDialog(SplashActivity.this);
		progressBar.setCanceledOnTouchOutside(false);
		progressBar.setMessage("Please wait for loading...");
		// progressBar.show();
		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}).start();
		progressBarHandler.postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent itentNextAct = new Intent(SplashActivity.this,
						MainActivity.class);
				startActivity(itentNextAct);
				finish();
			}
		}, SWITCH_TIME + 1000);
	}
}
