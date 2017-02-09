package me.xqstrive.simplev.compile.token;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleTokenElse implements WordBean, SimpleToken {
    private String original;
    private int type = ELSE;

    public SimpleTokenElse(String original){
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
    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean isType(int type) {
        return this.type==type;
    }

    @Override
    public java.lang.String toString() {
        return "SimpleTokenElse{" +
                "original='" + original + '\'' +
                ", type=" + type +
                '}';
    }

}
