package log;

/**
 * Created by wangqi on 2016/12/8.
 * inteface for Log, you just offer 3 level:info,warn,erro;
 * init can allow use any Log frame.it can be only used once.
 */
public interface Log {

    public void init();

    public void info(String massage);

    public void warn(String massage);

    public void erro(String massage);
}
