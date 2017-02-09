package me.xqstrive.simplev.compile.token;

/**
 * Created by wangqi on 2016/12/12.
 */
public interface SimpleToken {
    /*
     * define diferent type.
     */
    int getType();

    void setType(int tpye);

    String getOriginal();

    boolean isType(int type);

}
