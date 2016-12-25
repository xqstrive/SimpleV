package compile;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleTokenInclude implements SimpleToken,WordBean {
    private int type = INCLUDE;
    private String file;
    private String original;

    public SimpleTokenInclude(String original) {
        this.original = original;
    }

    public String getOriginal() {
        return original;
    }

    public String getFile() {
        return file;
    }

    public void setfile(String condiction) {
        this.file = condiction;
    }

    @Override
    public int getType() {
        return type;
    }

}
