package compile.grammar;

import compile.Template;
import compile.TemplateStream;
import compile.token.SimpleToken;
import compile.token.SimpleTokenInclude;
import context.Context;
import property.PropertyResource;

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
