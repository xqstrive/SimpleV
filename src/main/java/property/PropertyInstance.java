package property;

import app.SimpleV;
import log.Log;
import compile.TemplateStream;

import java.io.File;

/**
 * Created by wangqi on 2016/12/7.
 * init something for PropertyResource
 */
public class PropertyInstance {
    PropertyInstance(){}
    private Log log;
    private String encoding = "UTF-8";
    private String decoding = "UTF-8";
    private int templateMapMax = 50;
    private String staticFilePath = "//src//main//resources//";
    private boolean isTemplateMap = true;
    private TemplateStream templateStream;
    private SimpleV simpleV;

    public void init(){
        log = new log.SimpleLog();
        log.init();
    }

    public TemplateStream getTemplateStream() {
        return templateStream;
    }

    public void setTemplateStream(TemplateStream templateStream) {
        this.templateStream = templateStream;
    }

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

    public SimpleV getSimpleV() {
        return simpleV;
    }

    public void setSimpleV(SimpleV simpleV) {
        this.simpleV = simpleV;
    }

    public boolean isTemplateMap() {
        return isTemplateMap;
    }
}
