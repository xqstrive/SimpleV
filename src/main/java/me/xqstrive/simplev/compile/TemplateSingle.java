package me.xqstrive.simplev.compile;

import me.xqstrive.simplev.property.PropertyResource;
import me.xqstrive.simplev.template.TemplateByte;
import me.xqstrive.simplev.template.TemplateByteMem;

import java.io.IOException;

/**
 * Created by wangqi on 2016/12/12.
 */
public class TemplateSingle implements TemplateStream {
    public Template getTemplate(String fileRelativeName) {
        Template tb = new Template(fileRelativeName);
        try {
            tb.init();
        }catch (IOException e){
            PropertyResource.getLog().erro(e.getMessage());
        }
        return tb;
    }
}
