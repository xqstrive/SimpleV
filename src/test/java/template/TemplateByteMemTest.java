package template; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import property.PropertyInstance;
import property.PropertyResource;

/** 
* TemplateByteMem Tester. 
* 
* @author <Authors name> 
* @since <pre>21, 12, 2016</pre>
* @version 1.0 
*/ 
public class TemplateByteMemTest {
    TemplateByte tb = new TemplateByteMem("test.txt");
@Before
public void before() throws Exception {
    tb.init();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getHashCode() 
* 
*/ 
@Test
public void testGetHashCode() throws Exception { 
//TODO: Test goes here...
    //System.out.println(tb.getHashCode());
} 

/** 
* 
* Method: getTemplate() 
* 
*/ 
@Test
public void testGetTemplate() throws Exception { 
//TODO: Test goes here...
    String filestring = new String(tb.getTemplate(),PropertyResource.getDecoding());
    System.out.println(filestring);

} 


/** 
* 
* Method: init(String fileName) 
* 
*/ 
@Test
public void testInit() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = TemplateByteMem.getClass().getMethod("init", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
