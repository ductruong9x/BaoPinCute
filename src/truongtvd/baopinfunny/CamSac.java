package truongtvd.baopinfunny;

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

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class CamSac extends Activity {
	TextView edTitleCamSac, edNoiDungCamSac, edNoiDungButtonCamSac;
	Button btnCapNhatCamSac;
	private AdView adView;
	CheckBox cboCamSac;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cam_sac);
		adView = new AdView(this, AdSize.BANNER, "a1527e5b1a16616");
	    LinearLayout layout = (LinearLayout)findViewById(R.id.LinearLayout3);
	    
	    layout.addView(adView);

	    adView.loadAd(new AdRequest());
	    cboCamSac=(CheckBox)findViewById(R.id.cboCamSac);
		edTitleCamSac = (EditText) findViewById(R.id.edTitleCamSac);
		edNoiDungCamSac = (EditText) findViewById(R.id.edNoiDungCamSac);
		edNoiDungButtonCamSac = (EditText) findViewById(R.id.edNoiDungNutCamSac);
		cboCamSac.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				SharedPreferences myShare = getSharedPreferences("thongtin",
						MODE_PRIVATE);
				SharedPreferences.Editor edit=myShare.edit();
				if(isChecked==true){
					edit.putBoolean("ktCamSac", true);
					edit.commit();
				}else{
					edit.putBoolean("ktCamSac", false);
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
		boolean ktCamSac=myShare.getBoolean("ktCamSac", true);
		String title = myShare.getString("titleCamSac", "");
		String noidung = myShare.getString("noidungCamSac", "");
		String noidungbutton = myShare.getString("titlebuttonCamSac", "");
		cboCamSac.setChecked(ktCamSac);
		edTitleCamSac.setText(title);
		edNoiDungCamSac.setText(noidung);
		edNoiDungButtonCamSac.setText(noidungbutton);
	
	}
	
	public void btnCapNhatCamSac(View v) {
		SharedPreferences myShare = getSharedPreferences("thongtin",
				MODE_PRIVATE);
		SharedPreferences.Editor edit = myShare.edit();
		edit.putString("titleCamSac", edTitleCamSac.getText().toString());
		edit.putString("noidungCamSac", edNoiDungCamSac.getText().toString());
		edit.putString("titlebuttonCamSac", edNoiDungButtonCamSac.getText().toString());
		edit.commit();
		Toast.makeText(getApplication(), "Cập nhật thành công",
				Toast.LENGTH_SHORT).show();

	}
}
