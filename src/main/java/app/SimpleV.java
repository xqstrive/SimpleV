package app;

import org.w3c.dom.*;
import property.PropertyResource;
import compile.TemplateStreamFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by wangqi on 2016/12/7.
 * Copyright
 */
public class SimpleV {
    public SimpleV(){}
    public static void init(){
        /*配置初始化*/
        PropertyResource.init();
        PropertyResource.setUserDir(System.getProperty("user.dir"));
        String fileDir = PropertyResource.getUserDir() + File.separator + "resources"+ File.separator;
        String encoding = "UTF-8";
        boolean isTemplateMap = true;
        int templateMaxNum = 50;
        /*设置默认值*/
        PropertyResource.setStaticFilePath(fileDir);
        PropertyResource.setEncoding(encoding);
        PropertyResource.setIsTemplateMap(true);

        File conficFile = new File(PropertyResource.getUserDir() + File.separator + "simplev.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        /*过滤空白字符*/
        documentBuilderFactory.setValidating(true);
        documentBuilderFactory.setIgnoringElementContentWhitespace(true);

        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(conficFile);
            Element rootElement = document.getDocumentElement();
            NodeList nodeListofRoot = rootElement.getChildNodes();
            for(int i=0;i<nodeListofRoot.getLength();i++){
                dealWithNode(nodeListofRoot.item(i));
            }
        } catch (Exception e){
            PropertyResource.getLog().erro(e.getMessage());
        }

        PropertyResource.setTemplateStream(new TemplateStreamFactory().CreateTemplateStream(PropertyResource.getIsTemplateMap()));
    }

    private static SimpleVEngine engine(String fileName){
        return new SimpleVEngine(fileName);
    }


    private static void dealWithNode(Node node){
        if (node.getNodeName().equals("file-dir")){
            setFileDir(node);
        }
        else if(node.getNodeName().equals("encoding")){
            setEncoding(node);
        }
        else if(node.getNodeName().equals("template")){
            setTemplate(node);
        }
        else{
            String info = " In configuration file:" + PropertyResource.getUserDir() + File.separator + "simplev.xml"
                    + " node:" + node.getNodeName() + " has erro.";
            PropertyResource.getLog().erro(info);
        }
    }

    private static void setFileDir(Node node) {
        Element fileDirElement = (Element)node;
        Text dir = (Text) fileDirElement.getFirstChild();
        if (!dir.getData().trim().isEmpty()) {
            PropertyResource.setStaticFilePath(dir.getData().trim());
        }
    }
    private static void setEncoding(Node node){
        Element encodingElement = (Element)node;
        Text encoding = (Text) encodingElement.getFirstChild();
        if (!encoding.getData().trim().isEmpty()) {
            PropertyResource.setEncoding(encoding.getData().trim());
        }
    }
    private static void setTemplate(Node node){
        if (node.getFirstChild()!=null){
            Element isTemplateElement = (Element)node.getFirstChild();
            Text isTemplate = (Text) isTemplateElement.getFirstChild();
            if (!isTemplate.getData().trim().isEmpty()) {
                PropertyResource.setIsTemplateMap(Boolean.parseBoolean(isTemplate.getData().trim()));
            }
        }
    }

}
