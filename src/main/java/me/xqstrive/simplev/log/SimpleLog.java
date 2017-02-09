package me.xqstrive.simplev.log;


import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by wangqi on 2016/12/8.
 */
public class SimpleLog implements Log{
    public SimpleLog(){}

    public SimpleLog(String logName){ LOG_NAME = logName;}

    private static final String LOG_FOLDER_PRE = "SimpleLog";
    private static final String LOG_FILE_NAME = "Simple.log";
    private static String LOG_NAME = "Simple";

    private static Logger logger = Logger.getLogger(LOG_NAME);

    public  void init() {
        setLoggerHanlder();
        info("Simple log init........");
        info("Simple log at \"" + getLogFileName() + "\"");
    }

    public void info(String massage) {
        logger.info(massage);
    }

    public void warn(String massage) {
        logger.warning(massage);
    }

    public void erro(String massage) {
        logger.severe(massage);
    }

    private String getLogFileName(){
        StringBuffer fileName = new StringBuffer();
        fileName.append(System.getProperty("user.dir"));
        fileName.append(File.separatorChar);
        fileName.append(LOG_FOLDER_PRE);
        File file = new File(fileName.toString());
        if (!file.exists())
            file.mkdir();
        fileName.append(File.separatorChar);
        fileName.append(LOG_FILE_NAME);
        return fileName.toString();
    }

    private void setLoggerHanlder() {
        FileHandler fileHandler = null;
        try {
            //文件日志内容标记为可追加
            fileHandler = new FileHandler(getLogFileName(),10240,5,true);
            //以文本的形式输出
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.INFO);
        } catch (SecurityException e) {
            logger.severe(populateExceptionStackTrace(e));
        } catch (IOException e) {
            logger.severe(populateExceptionStackTrace(e));
        }
    }

    private String populateExceptionStackTrace(Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append(e.toString()).append("\n");
        for (StackTraceElement elem : e.getStackTrace()) {
            sb.append("\tat ").append(elem).append("\n");
        }
        return sb.toString();
    }
}
