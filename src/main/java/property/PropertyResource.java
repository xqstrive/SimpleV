package property;

import log.Log;

/**
 * Created by wangqi on 2016/12/7.
 * properties for SimpleV.
 * NO THREAD SAFETY.
 */
public class PropertyResource {

    private static PropertyInstance pi = new PropertyInstance();

    public static String getDecoding() {
        return pi.getDecoding();
    }

    public static String getEncoding() {
        return pi.getEncoding();
    }

    public static Log getLog(){
        return pi.getLog();
    }
}
