package me.xqstrive.simplev.compile;

import me.xqstrive.simplev.compile.token.SimpleToken;
import me.xqstrive.simplev.compile.token.SimpleTokens;
import me.xqstrive.simplev.compile.token.SimpleWords;
import me.xqstrive.simplev.property.PropertyResource;
import me.xqstrive.simplev.template.TemplateByte;
import me.xqstrive.simplev.template.TemplateByteMem;

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
