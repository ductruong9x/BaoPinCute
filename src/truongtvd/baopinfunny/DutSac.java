package truongtvd.baopinfunny;



import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class DutSac extends Activity {
	TextView edTitleDutSac, edNoiDungDutSac, edNoiDungButtonDutSac;
	Button btnCapNhatDutSac;
	private AdView adView;
	CheckBox cboDutSac,cboAmThanhDutSac;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dut_sac);
		adView = new AdView(this, AdSize.BANNER, "a152842a3194432");
		LinearLayout layout = (LinearLayout) findViewById(R.id.LinearLayout5);

		layout.addView(adView);

		adView.loadAd(new AdRequest());
		cboDutSac = (CheckBox) findViewById(R.id.cboDutSac);
		cboAmThanhDutSac=(CheckBox)findViewById(R.id.cboAmLuongDutSac);
		edTitleDutSac = (EditText) findViewById(R.id.edTitleDutSac);
		edNoiDungDutSac = (EditText) findViewById(R.id.edNoiDungDutSac);
		edNoiDungButtonDutSac = (EditText) findViewById(R.id.edNoiDungNutDutSac);
		cboAmThanhDutSac.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				SharedPreferences myShare = getSharedPreferences("thongtin",
						MODE_PRIVATE);
				SharedPreferences.Editor edit = myShare.edit();
				if (isChecked == true) {
					edit.putBoolean("ktAmThanhDutSac", true);
					edit.commit();
				} else {
					edit.putBoolean("ktAmThanhDutSac", false);
					edit.commit();
				}
			}
		});
		cboDutSac.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				SharedPreferences myShare = getSharedPreferences("thongtin",
						MODE_PRIVATE);
				SharedPreferences.Editor edit = myShare.edit();
				if (isChecked == true) {
					edit.putBoolean("ktDutSac", true);
					edit.commit();
				} else {
					edit.putBoolean("ktDutSac", false);
					edit.commit();
				}
			}
		});
	}

	@Override
	public void onDestroy() {
		if (adView != null) {
			adView.destroy();
		}
		super.onDestroy();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		SharedPreferences myShare = getSharedPreferences("thongtin",
				MODE_PRIVATE);
		boolean ktDutSac=myShare.getBoolean("ktDutSac", true);
		String title = myShare.getString("titleDutSac", "");
		String noidung = myShare.getString("noidungDutSac", "");
		String noidungbutton = myShare.getString("titlebuttonDutSac", "");
		boolean ktAmThanhDutSac=myShare.getBoolean("ktAmThanhDutSac", true);
		cboAmThanhDutSac.setChecked(ktAmThanhDutSac);
		cboDutSac.setChecked(ktDutSac);
		edTitleDutSac.setText(title);
		edNoiDungDutSac.setText(noidung);
		edNoiDungButtonDutSac.setText(noidungbutton);
		AdflexHelper.show(this);
		AdflexHelper.enableGift(getApplication());
	}

	public void btnCapNhatDutSac(View v) {
		SharedPreferences myShare = getSharedPreferences("thongtin",
				MODE_PRIVATE);
		SharedPreferences.Editor edit = myShare.edit();
		edit.putString("titleDutSac", edTitleDutSac.getText().toString());
		edit.putString("noidungDutSac", edNoiDungDutSac.getText().toString());
		edit.putString("titlebuttonDutSac", edNoiDungButtonDutSac.getText()
				.toString());
		edit.commit();
		Toast.makeText(getApplication(), "Cập nhật thành công",
				Toast.LENGTH_SHORT).show();

	}
}
