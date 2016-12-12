package property;

import log.SimpleLog;
import log.Log;

import java.io.File;


/**
 * Created by wangqi on 2016/12/7.
 * init something for PropertyResource
 */
public class PropertyInstance {
    PropertyInstance(){}
    private Log log = new log.SimpleLog();
    private String encoding = "UTF-8";
    private String decoding = "UTF-8";
    private int templateMapMax = 50;
    private String staticFilePath = "//src//main//resources//";

    public String  getStatisFilePath(){
        return System.getProperty("user.dir")+ File.separatorChar+staticFilePath;
    }

    public Log getLog() {
        return log;
    }

    public  String getDecoding() {
        return decoding;
    }

    public String getEncoding() {
        return encoding;
    }

    public int getTemplateMapMax(){return templateMapMax;}
    //private
}
