package com.kyang.mybatis.session.impl;

import com.kyang.mybatis.mapping.MappedStatement;
import com.kyang.mybatis.session.Configuration;
import com.kyang.mybatis.session.SqlSession;

/**
 * @Author：wqy
 * @Description：
 * @create：2025-03-02
 */

public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statementId) {
        return (T) ("你被代理了！" + statementId);
    }

    @Override
    public <T> T selectOne(String statementId, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statementId);
        return (T) ("你被代理了！" + "\n方法：" + statementId + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
