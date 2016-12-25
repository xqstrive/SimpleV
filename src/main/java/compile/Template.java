package compile;

import compile.Grammar.SimpleGrammars;
import compile.Token.SimpleToken;
import compile.Token.SimpleTokens;
import compile.Token.SimpleWords;
import property.PropertyResource;
import template.TemplateByte;
import template.TemplateStream;

import java.io.IOException;

/**
 * Created by wangqi on 2016/12/23.
 */
public class SimpleTemplate{
    private String fileName;
    private String file;
    private String[] words;
    private SimpleToken[] simpleTokens;

    public SimpleTemplate(String fileName) {
        this.fileName = fileName;
        file = null;
        words = null;
        simpleTokens = null;
    }

    public void init()throws IOException{
        TemplateStream ts = PropertyResource.getTemplateStream();
        TemplateByte tbm = ts.getTemplate(fileName);
        tbm.init();
        byte[] bs = tbm.getTemplate();
        file = new String(bs,PropertyResource.getEncoding());
        SimpleWords sw = new SimpleWords(file);
        words = sw.divideWord();
        SimpleTokens st = new SimpleTokens(words);
        st.analyze();
        simpleTokens = st.getSimpletokens();
    }

    public SimpleToken[] getSimpleTokens() {
        return simpleTokens;
    }
}
