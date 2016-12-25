package app; 

import context.Context;
import context.SimpleContext;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

/** 
* SimpleVEngine Tester. 
* 
* @author <Authors name> 
* @since <pre>12 23, 2016</pre>
* @version 1.0 
*/ 
public class SimpleVEngineTest { 
SimpleVEngine simpleVEngine = new SimpleVEngine("test.txt");
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: render(String fileName, Context con) 
* 
*/ 
@Test
public void testRender() throws Exception {
    SimpleV.init();
    Context con = new SimpleContext();
    con.put("x",true);
    con.put("include",5345);
    con.put("wang","fsdfsdf");
    List list = new ArrayList<String>();
    list.add("for1");
    list.add("for2");
    con.put("list",list);
    String html = simpleVEngine.render(con);
    System.out.println(html);
//TODO: Test goes here... 
} 


} 
