package truongtvd.baopinfunny;

import com.pushbots.push.Pushbots;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.text.Html;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

public class MainActivity extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.luachon);
		Pushbots.getInstance().regID();
		Preference pinYeu = (Preference) findPreference("pinyeu");
		pinYeu.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), PinYeu.class);
				startActivity(i);
				return false;
			}
		});
		Preference camXac = (Preference) findPreference("camsac");
		camXac.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), CamSac.class);
				startActivity(i);
				return false;
			}
		});
		Preference dutSac = (Preference) findPreference("ngatsac");
		dutSac.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), DutSac.class);
				startActivity(i);
				return false;
			}
		});
		danhGia();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void danhGia() {
		SharedPreferences getPre = getSharedPreferences("setting", MODE_PRIVATE);
		int i = getPre.getInt("VOTE", 0);
		SharedPreferences pre;
		SharedPreferences.Editor edit;
		switch (i) {
		case 0:
			pre = getSharedPreferences("setting", MODE_PRIVATE);
			edit = pre.edit();
			edit.putInt("VOTE", 1);
			edit.commit();
			break;
		case 1:
			pre = getSharedPreferences("setting", MODE_PRIVATE);
			edit = pre.edit();
			edit.putInt("VOTE", i + 1);
			edit.commit();
			break;
		case 2:
			pre = getSharedPreferences("setting", MODE_PRIVATE);
			edit = pre.edit();
			edit.putInt("VOTE", i + 1);
			edit.commit();
			break;
		case 3:
			pre = getSharedPreferences("setting", MODE_PRIVATE);
			edit = pre.edit();
			edit.putInt("VOTE", i + 1);
			edit.commit();
			break;
		case 4:
			pre = getSharedPreferences("setting", MODE_PRIVATE);
			edit = pre.edit();
			edit.putInt("VOTE", i + 1);
			edit.commit();
			break;
		case 5:
			final Dialog dialog = new Dialog(this);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setContentView(R.layout.dialog_vote);
			
//			dialog.getWindow().setBackgroundDrawable(
//					new ColorDrawable(Color.argb(50, 255, 255, 255)));
			Button btnVote = (Button) dialog.findViewById(R.id.btnVote);
			Button btnKhong = (Button) dialog.findViewById(R.id.btnKhong);
			Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
			btnVote.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent goToMarket = new Intent(Intent.ACTION_VIEW)
							.setData(Uri.parse("market://details?id="
									+ getPackageName()));
					startActivity(goToMarket);
				}
			});
			btnKhong.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					SharedPreferences pre = getSharedPreferences("setting",
							MODE_PRIVATE);
					SharedPreferences.Editor edit = pre.edit();
					edit.putInt("VOTE", 6);
					edit.commit();
					dialog.dismiss();
				}
			});
			btnCancel.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			});
			pre = getSharedPreferences("setting", MODE_PRIVATE);
			edit = pre.edit();
			edit.putInt("VOTE", 5);
			edit.commit();
			dialog.show();
			break;
		}
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.moreApp:
			Intent goMoreApp = new Intent(Intent.ACTION_VIEW)
					.setData(Uri
							.parse("https://play.google.com/store/apps/developer?id=TRUONGTVD"));
			startActivity(goMoreApp);
			break;
		case R.id.danhgia:
			Intent goToMarket = new Intent(Intent.ACTION_VIEW).setData(Uri
					.parse("market://details?id=" + getPackageName()));
			startActivity(goToMarket);
			break;
		case R.id.gioithieu:
			AlertDialog.Builder gioithieu = new AlertDialog.Builder(this);
			gioithieu
					.setTitle(
							Html.fromHtml("<font color='#1AA1E1' size='25'>Giới thiệu</font>"))
					.setIcon(R.drawable.icon);
			gioithieu
					.setMessage(Html
							.fromHtml("<font color='#1AA1E1' size='25'>App Name: Báo Pin Funny</font><br/><font color='#1AA1E1' size='25'>Email tác giả: ductruongcntt@gmail.com</font><br/><font color='#1AA1E1' size='25'>Version: 1.4</font>"));

			gioithieu.setPositiveButton(Html
					.fromHtml("<font color='#1AA1E1' size='25'>Đóng</font>"),
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();

						}
					});
			gioithieu.create().show();
			break;
		case R.id.chiase:
			String smsBody = "Phan mem bao pin vui. moi nguoi tai ve nhe:\n market://details?id=truongtvd.baopinfunny";
			Intent sendIntent = new Intent(Intent.ACTION_VIEW);
			sendIntent.putExtra("sms_body", smsBody);
			sendIntent.setType("vnd.android-dir/mms-sms");
			startActivity(sendIntent);
			break;
		case R.id.phanhoi:
			AlertDialog.Builder messageError = new AlertDialog.Builder(this);
			messageError
					.setTitle(
							Html.fromHtml("<font color='#1AA1E1' size='25'>Báo lỗi</font>"))
					.setIcon(R.drawable.icon);
			messageError
					.setMessage(Html
							.fromHtml("<font color='#1AA1E1' size='25'>Cảm ơn bán đã báo lỗi cho chúng tôi.</font>"));
			messageError
					.setNeutralButton(
							Html.fromHtml("<font color='#1AA1E1' size='25'>Báo Lỗi</font>"),
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									// System.exit(0);
									Intent i = new Intent(Intent.ACTION_SEND);
									i.setType("message/rfc822");
									i.putExtra(
											Intent.EXTRA_EMAIL,
											new String[] { "ductruongcntt@gmail.com" });
									i.putExtra(Intent.EXTRA_SUBJECT,
											"Báo lỗi app " + getPackageName());
									i.putExtra(Intent.EXTRA_TEXT,
											"Mô tả lỗi gặp phải");
									try {
										startActivity(Intent.createChooser(i,
												"Send mail..."));
									} catch (android.content.ActivityNotFoundException ex) {
										Toast.makeText(
												MainActivity.this,
												"Không có ứng dụng Email nào được cài trên thiết bị của bạn.",
												Toast.LENGTH_SHORT).show();
									}
								}
							}

					);
			messageError
					.setPositiveButton(
							Html.fromHtml("<font color='#1AA1E1' size='25'>Hủy</font>"),
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();

								}
							});
			messageError.create().show();
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

	static boolean active = false;

	@Override
	public void onStart() {
		super.onStart();
		active = true;
	}

	@Override
	public void onStop() {
		super.onStop();
		active = false;
	}

	public static boolean isActive() {
		return active;
	}
	
}
