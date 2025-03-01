package com.kyang.mybatis.session.defaults;

import com.kyang.mybatis.binding.MapperRegistry;
import com.kyang.mybatis.session.SqlSession;

/**
 * @ Author：wqy
 * @ Description：
 * @ create：2025-03-01 15:15
 */

public class DefaultSqlSession implements SqlSession {

    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statementId) {
        return (T) ("你被代理了！" + "方法：" + statementId);
    }

    @Override
    public <T> T selectOne(String statementId, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statementId + "入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }
}
