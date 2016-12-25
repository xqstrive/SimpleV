package template;

/**
 * Created by wangqi on 2016/12/12.
 */
public class TemplateSingle implements TemplateStream {
    public TemplateByte getTemplate(String fileRelativeName) {
        TemplateByte tb = new TemplateByteMem(fileRelativeName);
        tb.init();
        return tb;
    }
}
