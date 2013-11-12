package truongtvd.baopinfunny;

import com.pushbots.push.Pushbots;

import android.app.Application;

public class MyApplication extends Application {
	public void onCreate() {
        super.onCreate();
        Pushbots.init(this, "489657936706","527f64de4deeae1c12000013");
        Pushbots.getInstance().setMsgReceiver(customPushReceiver.class);
        
     }
}
