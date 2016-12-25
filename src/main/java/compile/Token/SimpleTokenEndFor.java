package compile;

/**
 * Created by wangqi on 2016/12/13.
 */
public class SimpleTokenEndFor implements WordBean, SimpleToken {
    private int type = ENDFOR;
    private String original;

    public SimpleTokenEndFor(String original) {
        this.original = original;
    }

    public String getOriginal() {
        return original;
    }

    @Override
    public int getType() {
        return type;
    }
}
