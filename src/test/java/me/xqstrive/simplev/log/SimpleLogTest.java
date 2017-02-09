package log;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* SimpleLog Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®¶þÔÂ 8, 2016</pre> 
* @version 1.0 
*/ 
public class SimpleLogTest {
Log l = new SimpleLog();
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
    l.init();
} 

/** 
* 
* Method: info(String massage) 
* 
*/ 
@Test
public void testInfo() throws Exception { 
//TODO: Test goes here...
    l.info("info:test");

} 

/** 
* 
* Method: warn(String massage) 
* 
*/ 
@Test
public void testWarn() throws Exception { 
//TODO: Test goes here...
    l.warn("warn:test");
} 

/** 
* 
* Method: erro(String massage) 
* 
*/ 
@Test
public void testErro() throws Exception { 
//TODO: Test goes here...
    l.erro("erro:test");
} 


/** 
* 
* Method: makeFolder() 
* 
*/ 
@Test
public void testMakeFolder() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleLog.getClass().getMethod("makeFolder"); 
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
* Method: getLogFileName() 
* 
*/ 
@Test
public void testGetLogFileName() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleLog.getClass().getMethod("getLogFileName"); 
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
* Method: setLoggerHanlder() 
* 
*/ 
@Test
public void testSetLoggerHanlder() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleLog.getClass().getMethod("setLoggerHanlder"); 
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
* Method: populateExceptionStackTrace(Exception e) 
* 
*/ 
@Test
public void testPopulateExceptionStackTrace() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = SimpleLog.getClass().getMethod("populateExceptionStackTrace", Exception.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
