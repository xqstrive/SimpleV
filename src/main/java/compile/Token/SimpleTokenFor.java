package compile;

/**
 * Created by wangqi on 2016/12/13.
 */
public class SimpleTokenFor implements SimpleToken,WordBean {
    private final int type = FOR;
    private String original;
    private String x;
    private String lists;

    public SimpleTokenFor(String original) {
        this.original = original;
    }

    public String getOriginal() {
        return original;
    }

    public String getX() {
        return x;
    }

    public String getLists() {
        return lists;
    }

    public void setX(String x) {
        this.x = x;
    }

    public void setLists(String lists) {
        this.lists = lists;
    }

    @Override
    public int getType() {
        return type;
    }
}
