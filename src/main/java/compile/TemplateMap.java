package compile;

import property.PropertyResource;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by wangqi on 2016/12/7.
 * The class will load all template file about file that will be rendered.
 */

public class TemplateMap implements TemplateStream{
    private final int MAXNUM = PropertyResource.getTemplateMapMax();
    private int mapNum = 0;
    private Map<String, Template> templateMap;

    public TemplateMap() {
        templateMap = new Hashtable();
    }
    public void init(){};
    /*
     * This function is get template instance.if the template is not in map, new template will create.
     */
    public Template getTemplate(String fileRelativeName){
        Template template = templateMap.get(fileRelativeName);
        return template==null?putTemplate(fileRelativeName):template;
    }

    /*
     * This function is thread safety, anytime there is a thread allowed add template instance.
     * But the performance could be bad, so you can choose if use it.
     */
    private synchronized Template putTemplate(String fileRelativeName){
        /* There is a check if any other thread already add the  template */
        if(templateMap.containsKey(fileRelativeName)) return templateMap.get(fileRelativeName);
        if(mapNum == MAXNUM){
            String key = getRandomTem();
            templateMap.remove(key);
        }
        Template templatebyte = new Template(fileRelativeName);
        try {
            templatebyte.init();
        } catch (IOException e){
            PropertyResource.getLog().erro(e.getMessage());
        }
        templateMap.put(fileRelativeName,templatebyte);
        ++mapNum;
        return templatebyte;
    }

    private String getRandomTem(){
        int contain = templateMap.size();
        int ran = (int)(Math.random()*(contain+1));
        int i = 0;
        for(String e:templateMap.keySet()){
            if(i>=ran) return e;
        }
        /* There is a error if this return. */
        return null;
    }

}
