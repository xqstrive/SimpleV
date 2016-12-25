package compile.Grammar;

import compile.Token.SimpleToken;
import compile.Token.SimpleTokenVar;
import context.Context;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleGrammarVar implements SimpleGrammar {
    private SimpleTokenVar stv;
    private Context con;

    public SimpleGrammarVar(SimpleToken stv,Context con) {
        this.stv = (SimpleTokenVar)stv;
        this.con = con;
    }

    @Override
    public String getHtml() {
        Object var = con.get(stv.getVar());
        return (var==null)?"":var.toString();
    }
}
