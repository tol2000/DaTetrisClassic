package ua.odessa.tol2000.datetrisclassic;

import android.util.Log;

/**
 * Created by Us01 on 27.10.2017.
 */

public class LocalData {
    public static String getLogTagName() {
        //return R.class.get   getResource("app_name").;
        return "DaTetrisClassic";
    }

    public static void logV(String message) {
        Log.v(getLogTagName(),LocalUtils.getDate()+" "+message);
    }

    public static void logE(String message) {
        Log.e(getLogTagName(),LocalUtils.getDate()+" "+message);
    }
}
