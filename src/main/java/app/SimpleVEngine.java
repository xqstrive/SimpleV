package app;

import compile.grammar.SimpleGrammars;
import compile.Template;
import compile.TemplateStream;
import context.Context;
import property.PropertyResource;

/**
 * Created by wangqi on 2016/12/22.
 */
public class SimpleVEngine {
    private String fileName;

    public SimpleVEngine(String fileName) {
        this.fileName = fileName;
    }

    public String render(Context con){
        TemplateStream templateStream = PropertyResource.getTemplateStream();
        Template template = templateStream.getTemplate(fileName);
        SimpleGrammars sg = new SimpleGrammars(template,con);
        return sg.render();
    }
}
