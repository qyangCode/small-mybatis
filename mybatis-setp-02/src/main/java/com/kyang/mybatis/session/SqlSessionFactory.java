package com.kyang.mybatis.session;

/**
 * @ Author：wqy
 * @ Description：
 * @ create：2025-03-01 15:15
 */

public interface SqlSessionFactory {

    SqlSession openSession();
}
