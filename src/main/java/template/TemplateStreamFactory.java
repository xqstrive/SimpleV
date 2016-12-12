package template;

/**
 * Created by wangqi on 2016/12/12.
 */
public class TemplateStreamFactory {
    public TempalteStream CreateTemplateStream(boolean type){
        return type?(new TemplateMap()):(new TemplateSingle());
    }
}
