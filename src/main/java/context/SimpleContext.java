package context;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by wangqi on 2016/12/7.
 * the context must be (String,Object);
 */
public class SimpleContext implements Context{
    private Map context = null;
    public SimpleContext(){this.context = new HashMap();}
    public SimpleContext(Map context){this.context = context;}
    public SimpleContext(String K, Object V){context = (context == null ? new HashMap():context);context.put(K,V);}

    public Object get(String K){
        return (context.containsKey(K) == true ? context.get(K): null);
    }

    public void put(String K, Object V){
        context.put(K,V);
    }

    public boolean hasKey(String K){
        return context.containsKey(K);
    }

    public void remove(String K){
        context.remove(K);
    }
}
