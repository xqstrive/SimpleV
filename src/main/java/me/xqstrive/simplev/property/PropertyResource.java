package me.xqstrive.simplev.property;

import me.xqstrive.simplev.log.Log;
import me.xqstrive.simplev.compile.TemplateStream;

/**
 * Created by wangqi on 2016/12/7.
 * properties for system.
 * NO THREAD SAFETY.
 */
public class PropertyResource {

    private static PropertyInstance pi;

    public static void init(){
        pi = new PropertyInstance();
        pi.init();
    }

    public static String getEncoding() {
        return pi.getEncoding();
    }

    public static void setEncoding(String encoding){pi.setEncoding(encoding);}
    public static Log getLog(){
        return pi.getLog();
    }

    public static String getStaticFilePath(){return pi.getStaticFilePath();}

    public static void setStaticFilePath(String staticFilePath){
        pi.setStaticFilePath(staticFilePath);
    }

    public static int getTemplateMapMax(){
        return pi.getTemplateMapMax();
    }
    public static boolean getIsTemplateMap(){return pi.getIsTemplateMap();}

    public static void setIsTemplateMap(boolean isTemplateMap){pi.setIsTemplateMap(isTemplateMap);}

    public static TemplateStream getTemplateStream() {
        return pi.getTemplateStream();
    }

    public static void setTemplateStream(TemplateStream templateStream) {
        pi.setTemplateStream(templateStream);
    }

    public static String getUserDir(){
        return pi.getUserDir();
    }

    public static void setUserDir(String userDir){
        pi.setUserDir(userDir);
    }



}
