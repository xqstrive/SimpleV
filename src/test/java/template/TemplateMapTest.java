package template; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import property.PropertyResource;

/** 
* TemplateMap Tester. 
* 
* @author <Authors name> 
* @since <pre>12 12, 2016</pre>
* @version 1.0 
*/ 
public class TemplateMapTest { 
private TemplateMap tm = new TemplateMap();
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getTemplate(String fileRelativeName) 
* 
*/ 
@Test
public void testGetTemplate() throws Exception { 
//TODO: Test goes here...
    TemplateByte tb = tm.getTemplate("test.txt");
    String template = new String(tb.getTemplate(), PropertyResource.getDecoding());
    System.out.println(template);

    TemplateByte tb2 = tm.getTemplate("test.txt");
    String template2 = new String(tb2.getTemplate(), PropertyResource.getDecoding());
    System.out.println(template2);
} 


/** 
* 
* Method: putTemplate(String fileRelativeName) 
* 
*/ 
@Test
public void testPutTemplate() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = TemplateMap.getClass().getMethod("putTemplate", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: getRandomTem() 
* 
*/ 
@Test
public void testGetRandomTem() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = TemplateMap.getClass().getMethod("getRandomTem"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
