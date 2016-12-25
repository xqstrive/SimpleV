package compile;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleTokenEndIf implements WordBean, SimpleToken {
    private int type = ENDIF;
    private String original;

    public SimpleTokenEndIf(String original) {
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