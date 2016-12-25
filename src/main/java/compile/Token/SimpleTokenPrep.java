package compile.Token;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleTokenPrep implements SimpleToken, WordBean {
    private String original;
    private int type;


    public SimpleTokenPrep(int type, String original){
        this.original = original;
    }

    @Override
    public String getOriginal() {
        return original;
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
        return "SimpleTokenPrep{" +
                "original='" + original + '\'' +
                ", type=" + type +
                '}';
    }
}
