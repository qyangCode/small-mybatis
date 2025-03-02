package com.kyang.mybatis.binding;

import com.kyang.mybatis.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ Author：wqy
 * @ Description：
 * @ create：2025-03-01 14:11
 */

public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionUID = 42322234234L;

    private final Class<T> mapperInterface;

    private SqlSession sqlSession;

    public MapperProxy(Class<T> mapperInterface, SqlSession sqlSession) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            return sqlSession.selectOne(method.getName(), args);
        }
    }
}
