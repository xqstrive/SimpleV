package compile.Token;

import java.util.ArrayList;

import static compile.Token.WordBean.*;
import static compile.Token.WordBean.ENDIF;

/**
 * 词法分词类
 * 对介词，变量和html原文本进行的分析。初始化实例之后调用方法analyzeWord方法。
 * Created by wangqi on 2016/12/14.
 */
public class SimpleTokens {
    private String[] sections;
    private SimpleToken[] simpletokens = null;
    public SimpleTokens(String[] sections) {
        this.sections = sections;
    }

    public String[] getSections() {
        return sections;
    }

    public SimpleToken[] getSimpletokens() {
        return simpletokens;
    }

    public void analyze(){
        ArrayList arraylist = new ArrayList<SimpleToken>();
        analyzeWord(arraylist);
        analyzeGrammar(arraylist);
        this.simpletokens =  (SimpleToken[]) (arraylist.toArray(new SimpleToken[arraylist.size()]));
    }
    /**
     * 词法分析，返回token序列提供给语法分析使用。
     * @return void
     */
    private void analyzeWord(ArrayList <SimpleToken> arraylist) {
        if (sections != null) {
            SimpleToken st;
            for (String e : sections) {
                if ((st = isType(e)) != null) {
                    arraylist.add(st);
                }
            }
        }
    }

    /*
     * 语法分析
     */
    private void analyzeGrammar(ArrayList <SimpleToken> arraylist){
        int cur = 0;
        int end;
        while (cur<arraylist.size()){
            switch (arraylist.get(cur).getType()){
                case FOR:
                    end = findType(arraylist,cur,FOR,ENDFOR);
                    if ( end > cur){
                        SimpleTokenFor stf = (SimpleTokenFor) arraylist.get(cur);
                        stf.setIndexOfEndfor(end);
                        cur = end+1;
                    }
                    else {
                        arraylist.remove(cur);
                    }
                    break;
                case IF:
                    end=findType(arraylist,cur,IF,ENDIF);
                    if(end>cur){
                        SimpleTokenIf sti = (SimpleTokenIf)arraylist.get(cur);
                        sti.setIndexOfEndIf(end);

                        for (int i = cur+1;i<end;i++){
                            if (arraylist.get(i).isType(ELSE)){
                                if (!findElse(arraylist,i-1,cur)){
                                    arraylist.remove(i);
                                }
                            }
                        }
                        cur = end+1;
                    }
                    else {
                        arraylist.remove(cur);
                    }
                    break;
                case ENDIF:
                    arraylist.remove(cur);
                    break;
                case ENDFOR:
                    arraylist.remove(cur);
                    break;
                case ELSE:
                    arraylist.remove(cur);
                    break;
                case INCLUDE:

                default:
                    cur++;
            }
        }
    }

    private int findType(ArrayList <SimpleToken> arraylist, int cur,int fromTYPE,int toTYPE){
        int start = cur;
        int stack = 0;
        while (cur<arraylist.size()){
            if (arraylist.get(cur).getType()==toTYPE) {
                stack--;
                if (stack == 0)
                    break;
            }
            if (arraylist.get(cur).getType()==fromTYPE)
                stack++;
            cur++;
        }
        return cur==arraylist.size()?start:cur;
    }

    private boolean findElse(ArrayList <SimpleToken> arraylist, int cur,int start){
        int i;
        for (i = cur;i>=start;i--){
            if (arraylist.get(i).isType(IF) || arraylist.get(i).isType(ELSE)) {
                break;
            }
        }
        if (arraylist.get(i).isType(IF)){
            SimpleTokenIf sti;
            sti = (SimpleTokenIf)arraylist.get(i);
            sti.setIndexOfElse(i+2);
            return true;
        }
        return false;
    }

    private SimpleToken isType(String token) {
        if (token == null || token.isEmpty()) return null;
        if (token.startsWith("{{{") && token.endsWith("}}}")){
            return isTEXT(token.substring(3, token.length() - 3));
        }
        else if (token.startsWith("{{") && token.endsWith("}}")) {
            return isVarChar(token.substring(2, token.length() - 2));
        }
        else if (token.startsWith("{%") && token.endsWith("%}")) {
            String text = token.substring(2, token.length() - 2);
            String[] tokens = text.split(" ");
            int cur = 0;
            cur = skipBlank(tokens, cur);

            if (tokens[cur].equals("include")) {
                return isInclude(text);
            } else if (tokens[cur].equals("if")) {
                return isIf(text);
            } else if (tokens[cur].equals("else")) {
                return isElse(text);
            } else if (tokens[cur].equals("endif")) {
                return isEndIf(text);
            } else if (tokens[cur].equals("for")) {
                return isFor(text);
            } else if (tokens[cur].equals("endfor")) {
                return isEndFor(text);
            } else {
                return null;
            }
        } else {
            return new SimpleTokenHtml(token);
        }
    }

    private int skipBlank(String[] tokens, int cur) {
        int start = cur;
        while (cur < tokens.length && (tokens[cur].isEmpty() || tokens[cur] == null)) {
            ++cur;
        }
        return cur < tokens.length ? cur : start;
    }

    private SimpleToken isTEXT(String token){
        if (token == null || token.isEmpty()) {
            return null;
        }
        return new SimpleTokenHtml(token);
    }
    /*
     * 判断是否是变量类型；如果是var类型，返回的是var的token类实例；如果不是var类型返回null。其他类似。
     */
    private SimpleToken isVarChar(String token) {
        if (token == null || token.isEmpty()) {
            return null;
        }
        /* delete space ' ' in the string. */
        String[] tokens = token.split(" ");
        int cur = 0;
        int t = cur;
        cur = skipBlank(tokens, cur);
        /**
         * 测试变量是否符合规范，但是思考了之后还是去掉了，只要满足是一个连续的序列即可，只不过查找会失败而已。
         */
        if (cur < tokens.length && tokens[cur] != null && !tokens[cur].isEmpty()) {
            /* fist charset is "a-z", "A-Z", "_". */
            String news = tokens[cur];
            char c = news.charAt(0);
            if (c == '_' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                 /* charset is "a-z", "A-Z", "_", "0-9". */
                int i = 1;
                while (i < news.length()) {
                    c = news.charAt(i);
                    if (!(c == '_' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9'))
                        return null;
                    i++;
                }
                cur++;
                cur = skipBlank(tokens, cur);
                if (cur == tokens.length) {
                    SimpleTokenVar st = new SimpleTokenVar(token);
                    st.setVar(news);
                    return st;
                }
            }
        }
        return null;
    }

    /*
     * 判断是否为for中的关键词，并返回分析好的for类。
     */
    private SimpleToken isFor(String token) {
        if (token == null || token.isEmpty()) {
            return null;
        }
        String x;
        String lists;
        String[] tokens = token.split(" ");
        int cur = 0;
        cur = skipBlank(tokens, cur);
        if (cur < tokens.length && tokens[cur].equals("for")) {
            cur++;
            cur = skipBlank(tokens, cur);
            if (cur < tokens.length && isVarChar(tokens[cur]) != null) {
                x = tokens[cur];
                cur++;
                cur = skipBlank(tokens, cur);
                if (cur < tokens.length && tokens[cur].equals("in")) {
                    cur++;
                    cur = skipBlank(tokens, cur);
                    if (cur < tokens.length && isVarChar(tokens[cur]) != null) {
                        lists = tokens[cur];
                        cur++;
                        cur = skipBlank(tokens, cur);
                        if (cur == tokens.length) {
                            SimpleTokenFor stf = new SimpleTokenFor(token);
                            stf.setLists(lists);
                            stf.setX(x);
                            return stf;
                        }
                    }
                }
            }
        }
        return null;
    }

    private SimpleToken isEndFor(String token) {
        if (token == null || token.isEmpty()) {
            return null;
        }
        String[] tokens = token.split(" ");
        int cur = 0;
        cur = skipBlank(tokens, cur);
        if (cur < tokens.length && tokens[cur].equals("endfor")) {
            cur++;
            cur = skipBlank(tokens, cur);
            if (cur == tokens.length) {
                return new SimpleTokenEndFor(token);
            }
        }
        return null;
    }

    private SimpleToken isIf(String token) {
        if (token == null || token.isEmpty()) {
            return null;
        }
        String condition;
        String[] tokens = token.split(" ");
        int cur = 0;
        cur = skipBlank(tokens, cur);
        if (cur < tokens.length && tokens[cur].equals("if")) {
            cur++;
            cur = skipBlank(tokens, cur);
            if (cur < tokens.length && isVarChar(tokens[cur]) != null) {
                condition = tokens[cur];
                cur++;
                cur = skipBlank(tokens, cur);
                if (cur == tokens.length) {
                    SimpleTokenIf sti = new SimpleTokenIf(token);
                    sti.setCondiction(condition);
                    return sti;
                }
            }
        }
        return null;
    }

    private SimpleToken isElse(String token) {
        if (token == null || token.isEmpty()) {
            return null;
        }
        String[] tokens = token.split(" ");
        int cur = 0;
        cur = skipBlank(tokens, cur);
        if (cur < tokens.length && tokens[cur].equals("else")) {
            cur++;
            cur = skipBlank(tokens, cur);
            if (cur == tokens.length) {
                return new SimpleTokenElse(token);
            }
        }
        return null;
    }

    private SimpleToken isEndIf(String token) {
        if (token == null || token.isEmpty()) {
            return null;
        }
        String[] tokens = token.split(" ");
        int cur = 0;
        cur = skipBlank(tokens, cur);
        if (cur < tokens.length && tokens[cur].equals("endif")) {
            cur++;
            cur = skipBlank(tokens, cur);
            if (cur == tokens.length) {
                return new SimpleTokenEndIf(token);
            }
        }
        return null;
    }

    private SimpleToken isInclude(String token) {
        if (token == null || token.isEmpty()) {
            return null;
        }
        String file;
        String[] tokens = token.split(" ");
        int cur = 0;
        cur = skipBlank(tokens, cur);
        if (cur < tokens.length && tokens[cur].equals("include")) {
            cur++;
            cur = skipBlank(tokens, cur);
            if (cur < tokens.length) {
                file = tokens[cur];
                cur++;
                cur = skipBlank(tokens, cur);
                if (cur == tokens.length) {
                    SimpleTokenInclude sti = new SimpleTokenInclude(token);
                    sti.setfile(file);
                    return sti;
                }
            }
        }
        return null;
    }
}

