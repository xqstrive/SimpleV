package me.xqstrive.simplev.compile.grammar;

import me.xqstrive.simplev.compile.Template;
import me.xqstrive.simplev.compile.TemplateStream;
import me.xqstrive.simplev.compile.token.SimpleToken;
import me.xqstrive.simplev.compile.token.SimpleTokenInclude;
import me.xqstrive.simplev.context.Context;
import me.xqstrive.simplev.property.PropertyResource;

import java.util.List;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleGrammarInclude implements SimpleGrammar{
    private Context con;
    private SimpleTokenInclude st;
    private List<String> listInclude;

    public SimpleGrammarInclude(SimpleToken st, Context con) {
        this.con = con;
        this.st = (SimpleTokenInclude) st;
    }

    public void setListInclude(List<String> listInclude) {
        this.listInclude = listInclude;
    }

    @Override
    public String getHtml(){
        TemplateStream templateStream = PropertyResource.getTemplateStream();
        Template template = templateStream.getTemplate(st.getFile());
        SimpleGrammars sg = new SimpleGrammars(template,con);
        sg.setListInclude(listInclude);
        return sg.render();
    }
}
