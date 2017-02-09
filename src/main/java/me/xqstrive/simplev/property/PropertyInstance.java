package me.xqstrive.simplev.property;

import me.xqstrive.simplev.log.*;
import me.xqstrive.simplev.compile.TemplateStream;

import java.io.File;

/**
 * Created by wangqi on 2016/12/7.
 * init something for PropertyResource
 */
public class PropertyInstance {
    PropertyInstance(){}
    private Log log;
    private String encoding;
    private int templateMapMax;
    private String staticFilePath; //static file path
    private String userDir; //user dir path
    private boolean isTemplateMap;
    private TemplateStream templateStream;


    public void init(){
        templateMapMax = 50;
        log = new SimpleLog();
        log.init();
    }

    public Log getLog() {
        return log;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getStaticFilePath() {
        return staticFilePath;
    }

    public void setStaticFilePath(String staticFilePath) {
        this.staticFilePath = staticFilePath;
    }

    public String getUserDir() {
        return userDir;
    }

    public void setUserDir(String userDir) {
        this.userDir = userDir;
    }

    public int getTemplateMapMax() {
        return templateMapMax;
    }

    public boolean getIsTemplateMap() {
        return isTemplateMap;
    }

    public void setIsTemplateMap(boolean templateMap) {
        isTemplateMap = templateMap;
    }

    public TemplateStream getTemplateStream() {
        return templateStream;
    }

    public void setTemplateStream(TemplateStream templateStream) {
        this.templateStream = templateStream;
    }
}
