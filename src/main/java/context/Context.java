package context;

/**
 * Created by wangqi on 2016/12/7.
 * inface of Context.
 */
public interface Context {
    public Object get(String K);

    public void put(String K, Object V);

    public boolean hasKey(String K);

    public void remove(String K);
}
