package compile.Token;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleTokenEndIf implements WordBean, SimpleToken {
    private String original;
    private int type = ENDIF;


    public SimpleTokenEndIf(String original){
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
        return "SimpleTokenEndIf{" +
                "original='" + original + '\'' +
                ", type=" + type +
                '}';
    }
}