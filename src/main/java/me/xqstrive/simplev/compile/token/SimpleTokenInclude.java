package me.xqstrive.simplev.compile.token;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleTokenInclude implements SimpleToken,WordBean {
    private String original;
    private int type = INCLUDE;
    private String file;
    public SimpleTokenInclude(String original){
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
        return "SimpleTokenInclude{" +
                "original='" + original + '\'' +
                ", type=" + type +
                ", file='" + file + '\'' +
                '}';
    }
}
