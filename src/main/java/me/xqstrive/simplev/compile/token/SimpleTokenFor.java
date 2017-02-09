package me.xqstrive.simplev.compile.token;

/**
 * Created by wangqi on 2016/12/13.
 */
public class SimpleTokenFor implements SimpleToken,WordBean {
    private String original;
    private int type = FOR;

    private int indexOfEndfor;
    private String x;
    private String lists;

    public SimpleTokenFor(String original){
        this.original = original;
    }

    public int getIndexOfEndfor() {
        return indexOfEndfor;
    }

    public void setIndexOfEndfor(int indexOfEndfor) {
        this.indexOfEndfor = indexOfEndfor;
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
        return "SimpleTokenFor{" +
                "original='" + original + '\'' +
                ", type=" + type +
                ", indexOfEndif=" + indexOfEndfor +
                ", x='" + x + '\'' +
                ", lists='" + lists + '\'' +
                '}';
    }
}
