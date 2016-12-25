package compile;

import compile.token.SimpleToken;
import compile.token.SimpleTokens;
import compile.token.SimpleWords;
import property.PropertyResource;
import template.TemplateByte;
import template.TemplateByteMem;

import java.io.IOException;

/**
 * Created by wangqi on 2016/12/23.
 */
public class Template{
    private String fileName;
    private String file;
    private String[] words;
    private SimpleToken[] simpleTokens;

    public Template(String fileName) {
        this.fileName = fileName;
        file = null;
        words = null;
        simpleTokens = null;
    }

    public void init()throws IOException{
        TemplateByte tbm = new TemplateByteMem(fileName);
        tbm.init();
        byte[] bs = tbm.getTemplate();
        file = new String(bs,PropertyResource.getEncoding());
        SimpleWords sw = new SimpleWords(file);
        words = sw.divideWord();
        SimpleTokens st = new SimpleTokens(words);
        st.analyze();
        simpleTokens = st.getSimpletokens();
    }

    public String getFileName() {
        return fileName;
    }

    public SimpleToken[] getSimpleTokens() {
        return simpleTokens;
    }
}
