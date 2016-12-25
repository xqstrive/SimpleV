package property;

import app.SimpleV;
import log.Log;
import compile.TemplateStream;

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

    public static String getDecoding() {
        return pi.getDecoding();
    }

    public static String getEncoding() {
        return pi.getEncoding();
    }

    public static Log getLog(){
        return pi.getLog();
    }

    public static int getTemplateMapMax(){return pi.getTemplateMapMax();}

    public static String getStaticFilePath(){return pi.getStatisFilePath();}

    public static boolean getIsTemplateMap(){return pi.isTemplateMap();}

    public static TemplateStream getTemplateStream() {
        return pi.getTemplateStream();
    }

    public static void setTemplateStream(TemplateStream templateStream) {
        pi.setTemplateStream(templateStream);
    }

    public static void setSimpleV(SimpleV simpleV){pi.setSimpleV(simpleV);}

    public static SimpleV getSimpleV(){return pi.getSimpleV();}
}
