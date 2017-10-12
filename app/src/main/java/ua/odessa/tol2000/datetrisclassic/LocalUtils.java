package ua.odessa.tol2000.datetrisclassic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Us01 on 12.10.2017.
 */

public class LocalUtils {
    public static String getDate() {
        return (new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")).format(new Date());
    }
}
