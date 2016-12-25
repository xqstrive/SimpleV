package compile.token;

import java.util.ArrayList;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleWords {
    private String fileStrings;

    public SimpleWords(String html) {
        this.fileStrings = html;
    }
    /*
     * 分词，返回一个list，或许数组也可以
     */
    public String[] divideWord(){
        if(fileStrings !=null&& !fileStrings.isEmpty()) {
            ArrayList<String> arraylist = new ArrayList<String>();
            StringBuilder sb = new StringBuilder();
            int cur = 0;
            int sbLenth = fileStrings.length();
            int end;
            while (cur < sbLenth) {
                if (fileStrings.startsWith("{{{",cur)){
                    end = find(cur,"}}}");
                    if (end>cur){
                        if (sb.length()>0){
                            arraylist.add(sb.toString());
                            sb.delete(0,sbLenth);
                        }
                        arraylist.add(fileStrings.substring(cur,end));
                        cur = end;
                    }
                    else {
                        sb.append("{{{");
                        cur +=3;
                    }
                }
                else if (fileStrings.startsWith("{{",cur) ) {
                    end = find(cur, "}}");
                    int tmp = cur;
                    if (end > cur) {
                        if (sb.length() > 0) {
                            arraylist.add(sb.toString());
                            sb.delete(0, sbLenth);
                        }
                        arraylist.add(fileStrings.substring(cur, end));
                        cur = end;
                    } else {
                        sb.append("{{");
                        cur += 2;
                    }
                }
                else if (fileStrings.startsWith("{%",cur)) {
                    end = find(cur,"%}");
                    int tmp = cur;
                    if (end >cur){
                        if (sb.length()>0){
                            arraylist.add(sb.toString());
                            sb.delete(0,sbLenth);
                        }
                        String pre = fileStrings.substring(cur,end);
                        arraylist.add(pre);
                        cur = end;
                    }
                    else{
                        sb.append("{%");
                        cur += 2;
                    }
                } else {
                    sb.append(fileStrings.charAt(cur));
                    cur++;
                }
            }
            if (sb.length() > 0) arraylist.add(sb.toString());
            return (String[]) arraylist.toArray(new String[arraylist.size()]);
        }
        return null;
    }

    private int find(int cur,String token){
        int start = cur;
        while (cur<fileStrings.length()){
            if (fileStrings.charAt(cur)=='\n'){
                return cur+1;
            }
            if (fileStrings.startsWith(token,cur)){
                return cur+token.length();
            }
            cur++;
        }
        return start;
    }
}
