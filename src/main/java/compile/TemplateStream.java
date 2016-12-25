package template;

/**
 * Created by wangqi on 2016/12/12.
 */
public interface TemplateStream {
    int TEMPLATE_MAP = 0;
    int TEMPLATE_SINGLE = 1;
    TemplateByte getTemplate(String fileRelativeName);
}
