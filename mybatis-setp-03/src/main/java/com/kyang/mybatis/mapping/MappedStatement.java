package com.kyang.mybatis.mapping;

import com.kyang.mybatis.session.Configuration;

import java.util.Map;

/**
 * @Author：wqy
 * @Description：
 * @create：2025-03-02
 */

public class MappedStatement {
    private Configuration configuration;
    private String id;
    private SqlCommandType sqlCommandType;
    private String parameterType;
    private String resultType;
    private String sql;

    private Map<Integer, String> parameterMap;

    private MappedStatement() {
        // private constructor
    }

    public static class Builder {
        private MappedStatement mappedStatement = new MappedStatement();

        public Builder(Configuration configuration, String id, SqlCommandType sqlCommandType, String parameterType, String resultType, String sql, Map<Integer, String> parameterMap) {

            this.mappedStatement.configuration = configuration;
            this.mappedStatement.id = id;
            this.mappedStatement.sqlCommandType = sqlCommandType;
            this.mappedStatement.parameterType = parameterType;
            this.mappedStatement.resultType = resultType;
            this.mappedStatement.sql = sql;
            this.mappedStatement.parameterMap = parameterMap;
        }

        public MappedStatement build() {
            assert mappedStatement.configuration != null;
            assert mappedStatement.id != null;
            return mappedStatement;
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SqlCommandType getSqlCommandType() {
        return sqlCommandType;
    }

    public void setSqlCommandType(SqlCommandType sqlCommandType) {
        this.sqlCommandType = sqlCommandType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Map<Integer, String> getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(Map<Integer, String> parameterMap) {
        this.parameterMap = parameterMap;
    }
}
