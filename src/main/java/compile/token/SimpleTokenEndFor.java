package compile.token;

/**
 * Created by wangqi on 2016/12/13.
 */
public class SimpleTokenEndFor implements WordBean, SimpleToken {
    private String original;
    private int type = ENDFOR;


    public SimpleTokenEndFor(String original){
        this.original = original;
    }
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
        return "SimpleTokenEndFor{" +
                "original='" + original + '\'' +
                ", type=" + type +
                '}';
    }
}
