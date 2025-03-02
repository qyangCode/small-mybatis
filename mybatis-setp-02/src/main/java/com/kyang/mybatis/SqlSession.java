package com.kyang.mybatis;

/**
 * @ Author：wqy
 * @ Description：
 * @ create：2025-03-01 15:14
 */

public interface SqlSession {

    <T> T selectOne(String statementId) ;

    <T> T selectOne(String statementId, Object parameter) ;

    <T> T getMapper(Class<T> type);
}
