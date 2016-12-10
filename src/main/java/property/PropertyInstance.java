package property;

import log.SimpleLog;
import log.Log;

/**
 * Created by wangqi on 2016/12/7.
 * init something for PropertyResource
 */
public class PropertyInstance {
    PropertyInstance(){}
    private Log log = new log.SimpleLog();
    private String encoding = "utf-8";
    private String decoding = "urf-8";

    public Log getLog() {
        return log;
    }

    public  String getDecoding() {
        return decoding;
    }

    public String getEncoding() {
        return encoding;
    }


    //private
}
