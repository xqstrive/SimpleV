package template;

/**
 * Created by wangqi on 2016/12/12.
 */
public class TemplateSingle implements TempalteStream {
    public TemplateByte getTemplate(String fileRelativeName) {
        TemplateByte tb = new TemplateByteMem(fileRelativeName);
        tb.init();
        return tb;
    }
}
