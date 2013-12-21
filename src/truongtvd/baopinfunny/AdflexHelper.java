package truongtvd.baopinfunny;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import vn.adflex.sdk.AdFlexSDK;

/**
 *
 * @author hailx
 */
public class AdflexHelper {

    //<editor-fold defaultstate="collapsed" desc="AdFlexSDK Singleton">
    private static AdFlexSDK adflexInstance;

    public static AdFlexSDK getAdFlexSDK(Context context) {
        return adflexInstance != null ? adflexInstance : (adflexInstance = new AdFlexSDK(context));
    }
    //</editor-fold>

    /**
     * *
     * Hiển thị quảng cáo khi bật ứng dụng
     *
     * @param context
     */
    public static void show(Context context) {
        getAdFlexSDK(context).show();
    }

    /**
     * *
     * Hiển thị quảng cáo trong ứng dụng
     *
     * @param context
     */
    public static void showInApp(Context context) {
        getAdFlexSDK(context).showInApp();
    }

    /**
     * *
     * HIển thị quảng cáo khi tắt ứng dụng
     *
     * @param context
     */
    public static void showAtEnd(Context context) {
        getAdFlexSDK(context).showAtEnd();
    }

    /**
     * *
     * Bật biểu tượng hộp quà
     *
     * @param context
     */
    public static void enableGift(Context context) {
        Map<String, String> config = new HashMap<String, String>();
        config.put("gift_icon", "true");
        getAdFlexSDK(context).setConfig(config);
    }

    /**
     * *
     * Tắt biểu tượng hộp quà
     *
     * @param context
     */
    public static void disableGift(Context context) {
        Map<String, String> config = new HashMap<String, String>();
        config.put("gift_icon", "false");
        getAdFlexSDK(context).setConfig(config);
    }
}
