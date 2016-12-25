package compile;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleTokenElse implements WordBean, SimpleToken {
    private String original;
    private int type = ELSE;

    SimpleTokenElse(String original){
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
