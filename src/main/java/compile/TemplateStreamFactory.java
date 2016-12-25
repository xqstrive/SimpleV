package template;

import static template.TemplateStream.TEMPLATE_MAP;
import static template.TemplateStream.TEMPLATE_SINGLE;

/**
 * Created by wangqi on 2016/12/12.
 */
public class TemplateStreamFactory {
    public TemplateStream CreateTemplateStream(boolean type){
        return type?new TemplateMap():new TemplateSingle();
//        switch (Type){
//            case TEMPLATE_MAP:
//                return new TemplateMap();
//            case TEMPLATE_SINGLE:
//                return new TemplateSingle();
//            default:
//                return null;
//        }
    }
}
