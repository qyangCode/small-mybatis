package com.kyang.mybatis.test.dao;

/**
 * @ Author：wqy
 * @ Description：
 * @ create：2025-03-01 14:27
 */

public interface IUserDao {
    String getUserById(int id);

    String getUserByName(String name);
}
