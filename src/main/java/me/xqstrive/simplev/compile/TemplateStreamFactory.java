package me.xqstrive.simplev.compile;

/**
 * Created by wangqi on 2016/12/12.
 */
public class TemplateStreamFactory {
    public TemplateStream CreateTemplateStream(boolean type){
        return type?new TemplateMap():new TemplateSingle();
    }
}
