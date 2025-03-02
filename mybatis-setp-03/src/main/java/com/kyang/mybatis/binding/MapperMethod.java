package com.kyang.mybatis.binding;

import com.kyang.mybatis.mapping.MappedStatement;
import com.kyang.mybatis.mapping.SqlCommandType;
import com.kyang.mybatis.session.Configuration;
import com.kyang.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Author：wqy
 * @Description：
 * @create：2025-03-02
 */

public class MapperMethod {

    private final SqlCommand sqlCommand;

    public MapperMethod(Configuration configuration, Class<?> mapperInterface, Method method) {
        sqlCommand = new SqlCommand(configuration, mapperInterface, method);
    }

    public Object execute(SqlSession sqlSession, Object[] args) {
        Object result = null;
        switch (sqlCommand.getType()) {
            case INSERT:
                break;
            case DELETE:
                break;
            case UPDATE:
                break;
            case SELECT:
                result = sqlSession.selectOne(sqlCommand.getName(), args);
                break;
            default:
                throw new RuntimeException("Unknown execution method for: " + sqlCommand.getName());
        }
        return result;
    }

    public static class SqlCommand {
        private String name;
        private SqlCommandType type;

        public SqlCommand(Configuration configuration, Class<?> mapperInterface, Method method) {
            String statementName = mapperInterface.getName() + "." + method.getName();
            MappedStatement ms = configuration.getMappedStatement(statementName);
            name = ms.getId();
            type = ms.getSqlCommandType();
        }

        public String getName() {
            return name;
        }

        public SqlCommandType getType() {
            return type;
        }
    }
}
