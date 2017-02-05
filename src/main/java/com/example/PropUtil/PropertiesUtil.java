package com.example.PropUtil;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


import javax.annotation.PostConstruct;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 2/5/17.
 */
@Component
public class PropertiesUtil {

    public Map<String,String> sqlmap = new HashMap<>();

    @PostConstruct
    protected final void loadSql() throws Throwable{

        String filename = "data/skuCorrelationDao.xml";

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Resource resource = new ClassPathResource(filename);

        Document sqlDocument = builder.parse(resource.getInputStream());
        NodeList sqlList = sqlDocument.getElementsByTagName("query");
        Node cd;

        for(int i=0; i < sqlList.getLength();i++){
            cd =  sqlList.item(i);
            String key = cd.getAttributes().getNamedItem("key").getTextContent();
            sqlmap.putIfAbsent(key, cd.getTextContent());
        }

    }

}
