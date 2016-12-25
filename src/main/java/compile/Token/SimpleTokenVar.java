package compile;

import java.util.ArrayDeque;
/**
 * Created by wangqi on 2016/12/12.
 */
public class SimpleTokenVar implements SimpleToken,WordBean {
    private int type = VAR;
    private String var;
    private String original;

    public SimpleTokenVar(String original) {
        this.original = original;
    }

    public String getOriginal() {
        return original;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public int getType() {
        return type;
    }
}
