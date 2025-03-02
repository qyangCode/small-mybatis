package com.kyang.mybatis.test.dao;

import com.kyang.mybatis.test.po.User;

/**
 * @Author：wqy
 * @Description：一个简单的UserDao接口，用于测试mybatis的CRUD操作
 * @create：2025-03-02
 */

public interface IUserDao {
    String queryUserInfoById(int id);
}
