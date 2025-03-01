package com.kyang.mybatis.test;

import com.kyang.mybatis.binding.MapperProxyFactory;
import com.kyang.mybatis.test.dao.IUserDao;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author：wqy
 * @ Description：
 * @ create：2025-03-01 14:27
 */

public class ApiTest {
    @Test
    public void test_mapperProxy() {
        MapperProxyFactory<IUserDao> mapperProxyFactory = new MapperProxyFactory<>(IUserDao.class);

        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("com.kyang.mybatis.test.dao.IUserDao.getUserById","模拟执行 Mapper.xml 中 SQL 语句的操作：根据用户 ID 查询用户");
        sqlSession.put("com.kyang.mybatis.test.dao.IUserDao.getUserByName", "模拟执行 Mapper.xml 中 SQL 语句的操作：根据用户名称查询用户");

        IUserDao userDao = mapperProxyFactory.newInstance(sqlSession);
        System.out.println(userDao.getUserById(1));
        System.out.println(userDao.getUserByName("张三"));
    }
}
