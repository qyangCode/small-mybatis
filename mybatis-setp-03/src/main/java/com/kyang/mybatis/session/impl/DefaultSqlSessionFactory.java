package com.kyang.mybatis.session.impl;

import com.kyang.mybatis.session.Configuration;
import com.kyang.mybatis.session.SqlSession;
import com.kyang.mybatis.session.SqlSessionFactory;

/**
 * @Author：wqy
 * @Description：
 * @create：2025-03-02
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;

    }
        @Override
        public SqlSession openSession () {
            return new DefaultSqlSession(configuration);
        }

}
