package compile.token;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* SimpleWords Tester.
* 不能中文？
* @author <Authors name> 
* @since <pre>12 15, 2016</pre>
* @version 1.0 
*/ 
public class SimpleWordsTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 
private SimpleWords sw = new SimpleWords(//"fsdfasdfasdfadfasdf{%if%}fsdafdasfdsaf" +
        "{%if x %}\n" +
        "fsdafdfasdf\n" +
        "{%endif%}\n" +
        "{%else}\n" +
        "{{{{% for %}}}\n" +
        "{{}}\n"+
        "{%%}\n"+
        "" +
        "{{include}}\n" +
        "" +
        "{%for i in list%}\n" +
        "{{i}}\n" +
        "{%endfor%}\n");
/** 
* 
* Method: divideWord() 
* 
*/ 
@Test
public void testDivideWord() throws Exception { 
//TODO: Test goes here...
    System.out.println("test DivedeWord");
    String[] words = sw.divideWord();
    System.out.println(words.length);
    for (String e :words){
        System.out.println(e);
    }
} 


/** 
* 
* Method: find(int cur) 
* 
*/ 
@Test
public void testFind() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleWords.getClass().getMethod("find", int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
