package com.kyang.mybatis.session;

/**
 * @Author：wqy
 * @Description：
 * @create：2025-03-02
 */

public interface SqlSession {
    <T> T selectOne(String statementId);

    <T> T selectOne(String statementId, Object parameter);

    <T> T getMapper(Class<T> type);

    Configuration getConfiguration();
}
