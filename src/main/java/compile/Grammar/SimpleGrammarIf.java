package compile.Grammar;

import compile.Template;
import compile.Token.*;
import context.Context;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleGrammarIf implements SimpleGrammar{
    private Template template;
    private Context con;
    private int start;
    private int end;

    public SimpleGrammarIf(Template template, Context con, int start, int end) {
        this.template = template;
        this.con = con;
        this.start = start;
        this.end = end;
    }

    @Override
    public String getHtml() {
        SimpleToken[] ifForm = template.getSimpleTokens();
        if (start>end) return "";
        SimpleTokenIf sti = (SimpleTokenIf)ifForm[start];
        int indexOfElse = sti.getIndexOfElse();
        String condictionString = sti.getCondiction();
        Object condiction = con.get(condictionString);

        if ( condiction !=null && condiction instanceof Boolean){

            if (((Boolean) condiction).booleanValue()){
                return new SimpleGrammars(template,con,start+1,indexOfElse).render();
            }
            else {
                return new SimpleGrammars(template,con,indexOfElse+1,end).render();
            }
        }
        return "";
    }
}
