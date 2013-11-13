package truongtvd.baopinfunny;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.BatteryManager;
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
		int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
		boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||status ==BatteryManager.BATTERY_STATUS_FULL;
		int levet=intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
		if(intent.getAction().equals("android.intent.action.ACTION_BATTERY_CHANGED")){
			
			
			Intent myintent = new Intent(context, DialogCamSac.class);
			myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(myintent);
		}

		if (ktCamSac == true) {
			if (intent.getAction().equals(
					"android.intent.action.ACTION_POWER_CONNECTED")) {
				Log.v("LEVEL PIN", String.valueOf(levet));
				Toast.makeText(context, String.valueOf(levet), Toast.LENGTH_LONG).show();
				Intent myintent = new Intent(context, DialogCamSac.class);
				myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(myintent);
			}
		
		} else {

		}
	
		if (ktPinYeu == true) {
			if (intent.getAction().equals("android.intent.action.BATTERY_LOW")) {
				Intent myintent = new Intent(context, DialogThongBao.class);
				myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(myintent);
			}
		} else {

		}
		if (ktDutSac == true) {
			if (intent.getAction().equals(
					"android.intent.action.ACTION_POWER_DISCONNECTED")) {

				Intent myintent = new Intent(context, DialogDutSac.class);
				myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(myintent);
			}
		} else {

		}
	}

}
