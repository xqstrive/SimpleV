package me.xqstrive.simplev.compile.token;

import me.xqstrive.simplev.compile.grammar.SimpleGrammar;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleTokenHtml implements SimpleToken, WordBean,SimpleGrammar{
    private String original;
    private int type = HTML;

    public SimpleTokenHtml(String original){
        this.original = original;
    }


    public String getOriginal() {
        return original;
    }
    public String getHtml(){
        return original;
    }
    public void append(String addtion){
        StringBuilder sb = new StringBuilder(original);
        sb.append(addtion);
        original = sb.toString();
    }
    /*
     *清除同行空格和回车
     */
    public void removeReturnPre(){
        int i = 0;
        while (i<original.length() && original.charAt(i)!='\n'&&original.charAt(i)>0 && original.charAt(i)< 33){
            i++;
        }
        if (i<original.length() && original.charAt(i)=='\n'){
            original = original.substring(i+1,original.length());
        }
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
        return "SimpleTokenHtml{" +
                "original='" + original + '\'' +
                ", type=" + type +
                '}';
    }
}
