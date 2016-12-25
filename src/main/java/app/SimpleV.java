package app;

import property.PropertyResource;
import compile.TemplateStreamFactory;

/**
 * Created by wangqi on 2016/12/7.
 * Copyright
 */
public class SimpleV {
    public SimpleV(){}
    public static void init(){
        PropertyResource.init();
        PropertyResource.setTemplateStream(new TemplateStreamFactory().CreateTemplateStream(PropertyResource.getIsTemplateMap()));
    }

    public static SimpleVEngine engine(String fileName){
        return new SimpleVEngine(fileName);
    }
}
