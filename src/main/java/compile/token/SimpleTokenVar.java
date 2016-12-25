package compile.token;

/**
 * Created by wangqi on 2016/12/12.
 */
public class SimpleTokenVar implements SimpleToken,WordBean {
    private String original;
    private int type = VAR;
    private String var;
    public SimpleTokenVar(String original){
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

    @Override
    public void setType(int tpye) {
        this.type = tpye;
    }

    @Override
    public boolean isType(int type) {
        return this.type==type;
    }

    @Override
    public String toString() {
        return "SimpleTokenVar{" +
                "original='" + original + '\'' +
                ", type=" + type +
                ", var='" + var + '\'' +
                '}';
    }
}
