package truongtvd.baopinfunny;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class DialogThongBao extends Activity {
	TextView tvNoiDung,tvTitle;
	Button btnCancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_dialog);
		tvNoiDung = (TextView) findViewById(R.id.tvNoiDung);
		btnCancel = (Button) findViewById(R.id.btnCancel);
		tvTitle=(TextView)findViewById(R.id.tvTitle);
		btnCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Intent.ACTION_SCREEN_OFF);
				finish();
				startActivity(i);
				
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		SharedPreferences myShare = getSharedPreferences("thongtin",
				MODE_PRIVATE);
		String title = myShare.getString("title", "Pin yếu !!!");
		String noidung = myShare.getString("noidung", "Sắp hết pin");
		String buttontext=myShare.getString("titlebutton", "Đóng");
		tvTitle.setText(title);
		tvNoiDung.setText(noidung);
		btnCancel.setText(buttontext);
	}
}
