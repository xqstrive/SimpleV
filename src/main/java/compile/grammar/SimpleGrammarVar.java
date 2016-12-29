package compile.grammar;

import compile.token.SimpleToken;
import compile.token.SimpleTokenVar;
import context.Context;

import java.util.Arrays;
import java.util.Map;

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
        String[] vars = stv.getVar().split("\\.");
        if (vars != null && vars.length!=0) {
            Object var = con.get(vars[0]);
            return getVar(var, Arrays.copyOfRange(vars, 1, vars.length));
        }
        return "";
    }

    private String getVar(Object var,String[] vars){
        if (var!=null){
            if (var instanceof Map && vars!=null && vars.length!=0){
                return  getVar(((Map<String, Object>) var).get( vars[0]), Arrays.copyOfRange(vars,1,vars.length));
            }
            if ( vars==null || vars.length==0){
                StringBuilder stringBuilder = new StringBuilder(var.toString());
                return stringBuilder.toString();
            }
        }
        return "";
    }
}
