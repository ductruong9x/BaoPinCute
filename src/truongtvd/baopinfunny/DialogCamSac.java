package truongtvd.baopinfunny;

import android.os.BatteryManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DialogCamSac extends Activity {
	TextView tvNoiDungCamSac,tvTitleCamSac;
	Button btnCancelCamSac;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_dialog_cam_sac);
		tvNoiDungCamSac = (TextView) findViewById(R.id.tvNoiDungCamSac);
		btnCancelCamSac = (Button) findViewById(R.id.btnCancelCamSac);
		tvTitleCamSac=(TextView)findViewById(R.id.tvTitleCamSac);
		btnCancelCamSac.setOnClickListener(new OnClickListener() {
			
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
		String title = myShare.getString("titleCamSac", "Đã Cắm Sạc !!!");
		String noidung = myShare.getString("noidungCamSac", "Cắm sạc rồi nhé...");
		String buttontext=myShare.getString("titlebuttonCamSac", "Đóng");
		int mamau=myShare.getInt("mamau", -12234532);
		int mamauchu=myShare.getInt("mamauchu", -1);
		tvTitleCamSac.setTextColor(mamau);
		tvNoiDungCamSac.setTextColor(mamau);
		btnCancelCamSac.setBackgroundColor(mamau);
		btnCancelCamSac.setTextColor(mamauchu);
		tvTitleCamSac.setText(title);
		tvNoiDungCamSac.setText(noidung);
		btnCancelCamSac.setText(buttontext);
	}
}
