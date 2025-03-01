package com.kyang.mybatis.session.defaults;

import com.kyang.mybatis.binding.MapperRegistry;
import com.kyang.mybatis.session.SqlSession;
import com.kyang.mybatis.session.SqlSessionFactory;

/**
 * @ Author：wqy
 * @ Description：
 * @ create：2025-03-01 15:16
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
