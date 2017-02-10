package me.xqstrive.simplev.app;

import me.xqstrive.simplev.compile.grammar.SimpleGrammars;
import me.xqstrive.simplev.compile.Template;
import me.xqstrive.simplev.compile.TemplateStream;
import me.xqstrive.simplev.context.Context;
import me.xqstrive.simplev.property.PropertyResource;

/**
 * template engine for render.
 * Created by wangqi on 2016/12/22.
 */
public class SimpleVEngine {
    private String fileName;

    public SimpleVEngine(String fileName) {
        this.fileName = fileName;
    }

    /**
     * render function
     * @param con context for the dictionary in the file.
     * @return redered String
     */
    public String render(Context con){
        TemplateStream templateStream = PropertyResource.getTemplateStream();
        Template template = templateStream.getTemplate(fileName);
        SimpleGrammars sg = new SimpleGrammars(template,con);
        return sg.render();
    }
}
