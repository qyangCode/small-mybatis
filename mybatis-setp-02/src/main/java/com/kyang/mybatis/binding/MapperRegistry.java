package com.kyang.mybatis.binding;

import cn.hutool.core.lang.ClassScanner;
import com.kyang.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ Author：wqy
 * @ Description：Mapper映射器
 * @ create：2025-03-01 15:10
 */

public class MapperRegistry {
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
           throw new RuntimeException("Error creating mapper instance. Cause: " + e, e);
        }
    }

    private void addMapper(Class<?> type) {
        if (type.isInterface()) {
            if (knownMappers.containsKey(type)) {
                throw new RuntimeException("Duplicate mapper interface " + type.getName() + " found.");
            }
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    public void addMappers(String packageName) {
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for (Class<?> type : mapperSet) {
            addMapper(type);
        }
    }
}
