package compile.Token;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleTokenIf implements SimpleToken,WordBean {
    private String original;
    private int type = IF;

    private String condiction;
    private int indexOfElse;
    private int indexOfEndIf;

    public SimpleTokenIf(String original){
        this.original = original;
    }

    public String getOriginal() {
        return original;
    }

    public int getIndexOfElse() {
        return indexOfElse;
    }

    public void setIndexOfElse(int indexOfElse) {
        this.indexOfElse = indexOfElse;
    }

    public int getIndexOfEndIf() {
        return indexOfEndIf;
    }

    public void setIndexOfEndIf(int indexOfendfor) {
        this.indexOfEndIf = indexOfendfor;
    }

    public String getCondiction() {
        return condiction;
    }

    public void setCondiction(String condiction) {
        this.condiction = condiction;
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
        return "SimpleTokenIf{" +
                "original='" + original + '\'' +
                ", type=" + type +
                ", condiction='" + condiction + '\'' +
                ", indexOfElse=" + indexOfElse +
                ", indexOfEndfor=" + indexOfEndIf +
                '}';
    }
}
