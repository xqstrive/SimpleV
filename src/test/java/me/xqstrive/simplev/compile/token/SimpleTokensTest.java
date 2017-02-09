package compile.token;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* SimpleTokens Tester. 
* 
* @author <Authors name> 
* @since <pre>12 15, 2016</pre>
* @version 1.0 
*/ 
public class SimpleTokensTest {
    private SimpleWords sw = new SimpleWords(
            "{%%} fsdafdasfdsaf" +
                    "{%if    x %}" +
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
* Method: getSections() 
* 
*/ 
@Test
public void testGetSections() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: analyzeWord() 
* 
*/ 
@Test
public void testAnalyzeWord() throws Exception {
    String [] words = sw.divideWord();
    SimpleTokens st = new SimpleTokens(words);
    st.analyze();
    SimpleToken [] sts = st.getSimpletokens();
    for (SimpleToken e:sts){
        System.out.println(e.toString());
    }
//TODO: Test goes here... 
} 


/** 
* 
* Method: scanToken(ArrayList<SimpleToken> st) 
* 
*/ 
@Test
public void testScanToken() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleTokens.getClass().getMethod("scanToken", ArrayList<SimpleToken>.class); 
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
* Method: isPre(SimpleToken st) 
* 
*/ 
@Test
public void testIsPre() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleTokens.getClass().getMethod("isPre", SimpleToken.class); 
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
* Method: isType(String token) 
* 
*/ 
@Test
public void testIsType() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleTokens.getClass().getMethod("isType", String.class); 
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
* Method: skipBlank(String[] tokens, int cur) 
* 
*/ 
@Test
public void testSkipBlank() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleTokens.getClass().getMethod("skipBlank", String[].class, int.class); 
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
* Method: isVarChar(String token) 
* 
*/ 
@Test
public void testIsVarChar() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleTokens.getClass().getMethod("isVarChar", String.class); 
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
* Method: isFor(String token) 
* 
*/ 
@Test
public void testIsFor() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleTokens.getClass().getMethod("isFor", String.class); 
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
* Method: isEndFor(String token) 
* 
*/ 
@Test
public void testIsEndFor() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleTokens.getClass().getMethod("isEndFor", String.class); 
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
* Method: isIf(String token) 
* 
*/ 
@Test
public void testIsIf() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleTokens.getClass().getMethod("isIf", String.class); 
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
* Method: isElse(String token) 
* 
*/ 
@Test
public void testIsElse() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleTokens.getClass().getMethod("isElse", String.class); 
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
* Method: isEndIf(String token) 
* 
*/ 
@Test
public void testIsEndIf() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleTokens.getClass().getMethod("isEndIf", String.class); 
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
* Method: isInclude(String token) 
* 
*/ 
@Test
public void testIsInclude() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleTokens.getClass().getMethod("isInclude", String.class); 
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
* Method: isPrep(String token) 
* 
*/ 
@Test
public void testIsPrep() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleTokens.getClass().getMethod("isPrep", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
