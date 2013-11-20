package truongtvd.baopinfunny;

import java.io.IOException;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.BatteryManager;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

public class BcThonBao extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		SharedPreferences myShare = context.getSharedPreferences("thongtin",
				Context.MODE_PRIVATE);
		boolean ktCamSac = myShare.getBoolean("ktCamSac", true);
		boolean ktDutSac = myShare.getBoolean("ktDutSac", true);
		boolean ktPinYeu = myShare.getBoolean("ktPinYeu", true);
		boolean ktAmThanhPinYeu = myShare.getBoolean("ktAmThanhPinYeu", true);
		boolean ktRung = myShare.getBoolean("ktRung", true);
		boolean ktAmThanhCamSac = myShare.getBoolean("ktAmThanhCamSac", true);
		boolean ktAmThanhDutSac = myShare.getBoolean("ktAmThanhDutSac", true);
		if (intent.getAction().equals(
				"android.intent.action.ACTION_POWER_CONNECTED")) {
			if (ktAmThanhCamSac == true) {
				MediaPlayer mp = MediaPlayer.create(context, R.raw.connect);
				try {
					mp.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mp.start();
			} else {

			}
			if (ktCamSac == true) {
				Intent myintent = new Intent(context, DialogCamSac.class);
				myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(myintent);
			}

		} else {

		}

		Vibrator vide = (Vibrator) context
				.getSystemService(Context.VIBRATOR_SERVICE);
		if (intent.getAction().equals("android.intent.action.BATTERY_LOW")) {

			if (ktAmThanhPinYeu == true) {
				MediaPlayer mp = MediaPlayer.create(context, R.raw.pinyeu);
				try {
					mp.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mp.start();
			} else {

			}
			if (ktRung == true) {
				vide.vibrate(2000);
			} else {

			}
			if (ktPinYeu == true) {

				Intent myintent = new Intent(context, DialogThongBao.class);
				myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(myintent);
			}
		} else {

		}

		if (intent.getAction().equals(
				"android.intent.action.ACTION_POWER_DISCONNECTED")) {
			if (ktAmThanhDutSac == true) {
				MediaPlayer mp = MediaPlayer.create(context, R.raw.dutsac);
				try {
					mp.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mp.start();
			}else{
				
			}
			if (ktDutSac == true) {
				Intent myintent = new Intent(context, DialogDutSac.class);
				myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(myintent);
			}
		} else {

		}
	}

}
