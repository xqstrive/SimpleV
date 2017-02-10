package me.xqstrive.simplev.compile.grammar;

import me.xqstrive.simplev.compile.token.SimpleToken;
import me.xqstrive.simplev.compile.token.SimpleTokens;
import me.xqstrive.simplev.compile.token.SimpleWords;
import me.xqstrive.simplev.context.Context;
import me.xqstrive.simplev.context.SimpleContext;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

/** 
* SimpleGrammars Tester. 
* 
* @author <Authors name> 
* @since <pre>12 15, 2016</pre>
* @version 1.0 
*/ 
public class SimpleGrammarsTest {
    private SimpleWords sw = new SimpleWords("{%%} fsdafdasfdsaf" +
            "{%if x %}" +
            " true" +
            "{%else%}"+
            " false"+
            "{%endif%}" +
            " wwwwww"+
            "{%else%}" +
            "{{{ {% for %}}}" +
            "" +
            "{{include}}" +
            "" +
            "{%for i in list%}" +
            "{{i}}" +
            "{%endfor%}");
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: render() 
* 
*/ 
@Test
public void testRender() throws Exception {
    String [] words = sw.divideWord();
    SimpleTokens st = new SimpleTokens(words);
    st.analyze();
    SimpleToken[] sts=st.getSimpletokens();
    Context con = new SimpleContext();
    con.put("x","gdfgdfg");
    con.put("include",5345);
    con.put("wang","fsdfsdf");
    List list = new ArrayList<String>();
    list.add(con);
    list.add("for2");
    con.put("list",list);
    //SimpleGrammars sg = new SimpleGrammars(sts,con);
    //System.out.print(sg.render());
//TODO: Test goes here... 
} 


/** 
* 
* Method: analyzeGrammar() 
* 
*/ 
@Test
public void testAnalyzeGrammar() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleGrammars.getClass().getMethod("analyzeGrammar"); 
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
* Method: findType(int cur, int fromTYPE, int toTYPE) 
* 
*/ 
@Test
public void testFindType() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleGrammars.getClass().getMethod("findType", int.class, int.class, int.class); 
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
* Method: findElse(int cur, int start, int end) 
* 
*/ 
@Test
public void testFindElse() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleGrammars.getClass().getMethod("findElse", int.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
