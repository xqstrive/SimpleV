package me.xqstrive.simplev.app;

import me.xqstrive.simplev.context.Context;
import me.xqstrive.simplev.context.SimpleContext;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    System.out.println(System.getProperty("user.dir"));
    String x = "a.sdf";
    String[] a = x.split("\\.");
    if (a!=null){
        System.out.print(a.length);
    }
} 


} 
