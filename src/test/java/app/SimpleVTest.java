package app;

import context.Context;
import context.SimpleContext;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

/** 
*  Tester.
* 
* @author <Authors name> 
* @since <pre>12 16, 2016</pre>
* @version 1.0 
*/ 
public class SimpleVTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: init() 
* 
*/ 
@Test
public void testInit() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: render(String fileName, Context con) 
* 
*/ 
@Test
public void testRender() throws Exception { 
//TODO: Test goes here...
    Context con = new SimpleContext();
    con.put("x",true);
    con.put("include",5345);
    con.put("wang","fsdfsdf");
    List list = new ArrayList<String>();
    list.add("for1");
    list.add("for2");
    con.put("list",list);
    SimpleV.init();
    //System.out.print(SimpleV.render("test.txt",con));

//        BufferedReader  a = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\test.txt"));
//        File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\test.txt");
//        System.out.println("filename:"+ file.getName());
//        System.out.println("filename:"+ file.getParent());
//        StringBuilder sb = new StringBuilder();
//        char[] tmp = new char[1024];
//        int len;
//        try {
//            while ((len=a.read(tmp,0,1024)) !=-1){
//                sb.append(tmp,0,len);
//                System.out.println(len);
//            }
//        }catch (IOException e){
//            System.out.println(e.getMessage());
//        }finally {
//            a.close();
//        }
//        System.out.println(sb.toString());
//        String[] x= sb.toString().split("f");
//        for(String s:x){
//            System.out.println(s);
//        }
//        System.out.println(sb.toString().substring(0,1));
//        String s = null;
//        System.out.println("sdfsdfasdf".startsWith("sdf",7));
//        int end;
//        if ((end = 3)>0)System.out.println("end>0"+end );
//        Map map = new HashMap();
//        map.put("nicai",true);
//        map.put(43,9);
//
//        System.out.print(map.toString());
} 


} 
