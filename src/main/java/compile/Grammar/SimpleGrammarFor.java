package compile.Grammar;

import compile.Template;
import compile.Token.SimpleToken;
import compile.Token.SimpleTokenFor;
import context.Context;

import java.util.List;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleGrammarFor implements SimpleGrammar {
    private Template template;
    private Context con;
    private int start;
    private int end;

    public SimpleGrammarFor(Template template, Context con, int start, int end) {
        this.con = con;
        this.template = template;
        this.start = start;
        this.end = end;
    }

    @Override
    public String getHtml() {
        SimpleToken[] forForm = template.getSimpleTokens();
        if (start>end) return "";
        SimpleTokenFor stf = (SimpleTokenFor) forForm[start];
        String xString = stf.getX();
        String listString = stf.getLists();
        Object list = con.get(listString);
        StringBuilder sbHtml = new StringBuilder();
        if (list instanceof List){
            for(Object ob:(List)list){
                con.put(xString,ob);
                sbHtml.append(new SimpleGrammars(template,con,start+1,end).render());
            }
        }
        return sbHtml.toString();
    }
}
