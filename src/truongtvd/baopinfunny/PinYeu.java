package truongtvd.baopinfunny;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PinYeu extends Activity {
	TextView edTitle, edNoiDung, edNoiDungButton;
	Button btnCapNhat;
	private AdView adView;
	CheckBox cboPinYeu,cboRung,cboAmthanh;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pin_yeu);
		adView = new AdView(this, AdSize.BANNER, "a152842a3194432");
	    LinearLayout layout = (LinearLayout)findViewById(R.id.LinearLayout1);

	    layout.addView(adView);

	    adView.loadAd(new AdRequest());
		cboPinYeu = (CheckBox) findViewById(R.id.cboPinYeu);
		cboRung=(CheckBox)findViewById(R.id.cboRung);
		cboAmthanh=(CheckBox)findViewById(R.id.cboAmLuong);
		edTitle = (EditText) findViewById(R.id.edTitle);
		edNoiDung = (EditText) findViewById(R.id.edNoiDung);
		edNoiDungButton = (EditText) findViewById(R.id.edNoiDungNut);
		cboRung.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				SharedPreferences myShare = getSharedPreferences("thongtin",
						MODE_PRIVATE);
				SharedPreferences.Editor edit = myShare.edit();
				if (isChecked == true) {
					edit.putBoolean("ktRung", true);
					edit.commit();
				} else {
					edit.putBoolean("ktRung", false);
					edit.commit();
				}
			}
		});
		cboAmthanh.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				SharedPreferences myShare = getSharedPreferences("thongtin",
						MODE_PRIVATE);
				SharedPreferences.Editor edit = myShare.edit();
				if (isChecked == true) {
					edit.putBoolean("ktAmThanhPinYeu", true);
					edit.commit();
				} else {
					edit.putBoolean("ktAmThanhPinYeu", false);
					edit.commit();
				}
			}
		});
		cboPinYeu.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				SharedPreferences myShare = getSharedPreferences("thongtin",
						MODE_PRIVATE);
				SharedPreferences.Editor edit = myShare.edit();
				if (isChecked == true) {
					edit.putBoolean("ktPinYeu", true);
					edit.commit();
				} else {
					edit.putBoolean("ktPinYeu", false);
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
		boolean ktPinYeu=myShare.getBoolean("ktPinYeu", true);
		String title = myShare.getString("title", "");
		String noidung = myShare.getString("noidung", "");
		String noidungbutton = myShare.getString("titlebutton", "");
		boolean ktAmThanhPinYeu=myShare.getBoolean("ktAmThanhPinYeu", true);
		boolean ktRung=myShare.getBoolean("ktRung", true);
		cboAmthanh.setChecked(ktAmThanhPinYeu);
		cboRung.setChecked(ktRung);
		cboPinYeu.setChecked(ktPinYeu);
		edTitle.setText(title);
		edNoiDung.setText(noidung);
		edNoiDungButton.setText(noidungbutton);
		AdflexHelper.show(this);
		AdflexHelper.enableGift(getApplication());
	}
	
	public void btnCapNhat(View v) {
		SharedPreferences myShare = getSharedPreferences("thongtin",
				MODE_PRIVATE);
		SharedPreferences.Editor edit = myShare.edit();
		edit.putString("title", edTitle.getText().toString());
		edit.putString("noidung", edNoiDung.getText().toString());
		edit.putString("titlebutton", edNoiDungButton.getText().toString());
		edit.commit();
		Toast.makeText(getApplication(), "Cập nhật thành công",
				Toast.LENGTH_SHORT).show();

	}
}
