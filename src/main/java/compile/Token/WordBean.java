package compile;

/**
 * Created by wangqi on 2016/12/13.
 */
public interface WordBean {
    /**/
    int VAR_PRE = 0;/* {{ */
    int VAR_SUF = 1;/* }} */
    int PRE_PRE = 3;/* {% */
    int PRE_SUF = 4;/* %} */
    int VAR = 5;
    int INCLUDE =6;
    int FOR = 7;
    int ENDFOR = 8;
    int IF = 9;
    int ELSE = 10;
    int ENDIF = 11;
    int HTML = 12;
}
