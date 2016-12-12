package template;

import java.io.*;
import java.text.SimpleDateFormat;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import log.Log;
import property.PropertyResource;
/**
 * Created by wangqi on 2016/12/11.
 * load template file in mem, implement TemplateByte.
 */
public class TemplateByteMem implements TemplateByte {
    //private String filePath;
    private String fileRelativeName;
    //private String fileName;
    private File file;
    private Log log = PropertyResource.getLog();

    public TemplateByteMem(String fileRelativeName){
        this.fileRelativeName = fileRelativeName;
        //fileName = file.getName();
        //fileName = file.getAbsolutePath();
    }
    public void init(){
        this.file = new File(PropertyResource.getStaticFilePath() + fileRelativeName);
        //this.fileName = file.getName();
        //this.filePath = file.getPath();
        //this.hashCode = this.fileRelativeName;//+ " "+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(file.lastModified());
    }

//    public String getHashCode(){
//        return hashCode;
//    }

    public byte[] getTemplate() throws IOException{
        InputStream fileBR = new BufferedInputStream(new FileInputStream(file));
        int fileLen = getFileLen();
        byte[] fileChar = new byte[fileLen];
        int len;
        if((len=fileBR.read(fileChar,0,fileLen))!=fileLen){
            String message = "the file \""+ fileRelativeName+"\" load error."+" len is "+len+", but maxlen is "+file.length();
            log.erro(message);
            throw new IOException(message);
        }
        return fileChar;
    }

    private int getFileLen() {
        /**
         * the file lenth can not longer than Integer.MAX_VALUE,
         * there is not a Exception, because we assume that the template file is smaller than GB level(2^31).
         */
        if(file.length() > Integer.MAX_VALUE) {
            String message = "the file \"" + fileRelativeName + "\" is too big to load.";
            log.erro(message);
            //throw new IOException(message);
        }
        return (int)file.length();
    }
}
