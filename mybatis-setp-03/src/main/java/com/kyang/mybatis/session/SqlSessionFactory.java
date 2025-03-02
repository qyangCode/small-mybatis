package com.kyang.mybatis.session;

/**
 * @Author：wqy
 * @Description：
 * @create：2025-03-02
 */

public interface SqlSessionFactory {
    SqlSession openSession();
}
