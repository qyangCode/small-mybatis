package com.kyang.mybatis.builder.xml;

import com.kyang.mybatis.builder.BaseBuilder;
import com.kyang.mybatis.io.Resources;
import com.kyang.mybatis.mapping.MappedStatement;
import com.kyang.mybatis.mapping.SqlCommandType;
import com.kyang.mybatis.session.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author：wqy
 * @Description：
 * @create：2025-03-02
 */

public class XmLConfigBuilder extends BaseBuilder {

    private Element root;

    public XmLConfigBuilder(Reader reader) {
        super(new Configuration());

        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new InputSource(reader));
            root = document.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public Configuration parse() {
        try {
            mapperElement(root.element("mappers"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to parsemybatis configuration file. Cause: " + e, e);
        }
        return configuration;
    }

    private void mapperElement(Element mappers) throws Exception {
        List<Element> mapperList = mappers.elements("mapper");

        for (Element mapper : mapperList) {
            String resource = mapper.attributeValue("resource");
            Reader reader = Resources.getResourceAsReader(resource);
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new InputSource(reader));
            Element root = document.getRootElement();

            String namespace = root.attributeValue("namespace");

            List<Element> selectNodes = root.elements();

            for (Element node : selectNodes) {
                String id = node.attributeValue("id");
                String resultType = node.attributeValue("resultType");
                String parameterType = node.attributeValue("parameterType");
                String sql = node.getTextTrim();

                Map<Integer, String> parameterMap = new HashMap<>();
                Pattern pattern = Pattern.compile("(#\\{(.*?)})");
                Matcher matcher = pattern.matcher(sql);
                for (int i = 0; matcher.find(); i++) {
                    String g1 = matcher.group(1);
                    String g2 = matcher.group(2);
                    parameterMap.put(i, g2);
                    sql = sql.replace(g1, "?");
                }

                String msId = namespace + "." + id;
                String nodeName = node.getName();
                SqlCommandType sqlCommandType = SqlCommandType.valueOf(nodeName.toUpperCase(Locale.ENGLISH));
                configuration.addMappedStatement(new MappedStatement.Builder(configuration, msId, sqlCommandType, parameterType, resultType, sql, parameterMap).build());
            }

            // 加入mapper
            configuration.addMapper(Resources.classForName(namespace));
        }
    }
}
