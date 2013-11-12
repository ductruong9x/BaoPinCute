package truongtvd.baopinfunny;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DialogDutSac extends Activity {
	TextView tvNoiDungDutSac,tvTitleDutSac;
	Button btnCancelDutSac;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_dialog_dut_sac);
		tvNoiDungDutSac = (TextView) findViewById(R.id.tvNoiDungDutSac);
		btnCancelDutSac = (Button) findViewById(R.id.btnCancelDutSac);
		tvTitleDutSac=(TextView)findViewById(R.id.tvTitleDutSac);
		btnCancelDutSac.setOnClickListener(new OnClickListener() {
			
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
		String title = myShare.getString("titleDutSac", "Đã Dút sạc !!!");
		String noidung = myShare.getString("noidungDutSac", "Dút sạc rồi nhé...");
		String buttontext=myShare.getString("titlebuttonDutSac", "Đóng");
		tvTitleDutSac.setText(title);
		tvNoiDungDutSac.setText(noidung);
		btnCancelDutSac.setText(buttontext);
	}
}
