package truongtvd.baopinfunny;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogThongBao extends Activity {
	TextView tvNoiDung,tvTitle;
	Button btnCancel;
	ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_dialog);
		tvNoiDung = (TextView) findViewById(R.id.tvNoiDung);
		btnCancel = (Button) findViewById(R.id.btnCancel);
		img=(ImageView)findViewById(R.id.imageView1);
		tvTitle=(TextView)findViewById(R.id.tvTitle);
		btnCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();	
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
		int mamau=myShare.getInt("mamau", -12234532);
		int mamauchu=myShare.getInt("mamauchu", -1);
		tvTitle.setTextColor(mamau);
		tvNoiDung.setTextColor(mamau);
		btnCancel.setBackgroundColor(mamau);
		btnCancel.setTextColor(mamauchu);
		tvTitle.setText(title);
		tvNoiDung.setText(noidung);
		btnCancel.setText(buttontext);
	}
}
