package com.kyang.mybatis.session;

import com.kyang.mybatis.builder.xml.XmLConfigBuilder;
import com.kyang.mybatis.session.impl.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @Author：wqy
 * @Description：
 * @create：2025-03-02
 */

public class SqlSessionFactoryBuilder {

   public SqlSessionFactory build(Reader reader) {
       XmLConfigBuilder xmLConfigBuilder = new XmLConfigBuilder(reader);
       return new DefaultSqlSessionFactory(xmLConfigBuilder.parse());
   }
}
