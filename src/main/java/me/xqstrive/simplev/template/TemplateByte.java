package me.xqstrive.simplev.template;

import java.io.IOException;

/**
 * Created by wangqi on 2016/12/11.
 * we want to laod some template to mem, so every template is a TemplateByte class.you can implement it to
 * load template.
 */
public interface TemplateByte {
    /**
     * init something.
     */
    void init();

    /**
     * return byte[] and you can deep copy of it.
     * @return byte[]
     */
    byte[] getTemplate() throws IOException;

    //public void reload();
}
