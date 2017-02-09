package me.xqstrive.simplev.compile.grammar;

import me.xqstrive.simplev.compile.Template;
import me.xqstrive.simplev.compile.token.*;
import me.xqstrive.simplev.context.Context;
import me.xqstrive.simplev.property.PropertyResource;

import java.util.ArrayList;
import java.util.List;

import static me.xqstrive.simplev.compile.token.WordBean.*;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleGrammars {
    private Template template;

    private Context con;
    private int start;
    private int end;
    private List<String> listInclude;

    public void setListInclude(List listInclude) {
        this.listInclude = listInclude;
    }


    public SimpleGrammars(Template template, Context con, int start, int end) {
        this.template = template;
        this.con = con;
        this.start = start;
        this.end = end;
        listInclude = null;
    }

    public SimpleGrammars(Template template, Context con) {
        this.template = template;
        this.con = con;
        this.start = 0;
        this.end = template==null || template.getSimpleTokens()==null ? 0 : template.getSimpleTokens().length;
    }

    /*
     * 语法分析
     */
    public String render(){
        if (template == null){
            return "";
        }
        if (testInclude(template.getFileName())){
            StringBuilder erro = new StringBuilder("there is a loop in");
            for (String e :listInclude)
                erro.append(" -> "+e);
            PropertyResource.getLog().erro(erro.toString());
            return "";
        }
        SimpleToken[] simpletokens = template.getSimpleTokens();
        if (start >end) return "";
        if (simpletokens != null){
            StringBuilder sbHtml = new StringBuilder();
            int cur = start;
            int tmpEnd;
            while (cur<end){
                switch (simpletokens[cur].getType()){
                    case HTML:
                        sbHtml.append(simpletokens[cur].getOriginal());
                        cur++;
                        break;
                    case VAR:
                        sbHtml.append((new SimpleGrammarVar(simpletokens[cur],con)).getHtml());
                        cur++;
                        break;
                    case FOR:
                        SimpleTokenFor stf = (SimpleTokenFor) simpletokens[cur];
                        tmpEnd = stf.getIndexOfEndfor();
                        sbHtml.append((new SimpleGrammarFor(template,con,cur,tmpEnd)).getHtml());
                        cur = tmpEnd+1;
                        break;
                    case IF:
                        SimpleTokenIf sti = (SimpleTokenIf) simpletokens[cur];
                        tmpEnd = sti.getIndexOfEndIf();
                        sbHtml.append((new SimpleGrammarIf(template,con,cur,tmpEnd)).getHtml());
                        cur = tmpEnd+1;
                        break;
                    case INCLUDE:
                        SimpleGrammarInclude simpleGrammarInclude = new SimpleGrammarInclude(simpletokens[cur],con);
                        simpleGrammarInclude.setListInclude(listInclude);
                        sbHtml.append(simpleGrammarInclude.getHtml());
                        cur++;
                        break;
                    default:
                        sbHtml.append(simpletokens[cur].getOriginal());
                        cur++;
                        break;
                }
            }
            return sbHtml.toString();
        }
        return "";
    }
    private boolean testInclude(String fileName){
        if (listInclude != null)
            for (String e:listInclude){
                if (e.equals(fileName))
                    return true;
            }
        else{
            listInclude = new ArrayList<String>();
        }
        listInclude.add(fileName);
        return false;
    }
}