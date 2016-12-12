import java.io.*;
import java.util.Map;

/**
 * Created by wangqi on 2016/12/7.
 * Copyright
 */
public class SimpleV {
    private Map templateList = null;
    public SimpleV(){}
    public void init(){

    }
    public void engine(String templatename){

    }

    public static void main(String args[]) throws IOException{
        BufferedReader  a = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\test.txt"));
        File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\test.txt");
        System.out.println("filename:"+ file.getName());
        System.out.println("filename:"+ file.getParent());
        StringBuilder sb = new StringBuilder();
        char[] tmp = new char[1024];
        int len;
        try {
            while ((len=a.read(tmp,0,1024)) !=-1){
                sb.append(tmp,0,len);
                System.out.println(len);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            a.close();
        }
        System.out.println(sb.toString());
        while(true){}
    }

}
