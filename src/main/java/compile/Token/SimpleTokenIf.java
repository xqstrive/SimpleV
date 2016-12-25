package compile;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleTokenIf implements SimpleToken,WordBean {
    private int type = ENDIF;
    private String condiction;
    private String original;

    public SimpleTokenIf(String original) {
        this.original = original;
    }

    public String getOriginal() {
        return original;
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
}
