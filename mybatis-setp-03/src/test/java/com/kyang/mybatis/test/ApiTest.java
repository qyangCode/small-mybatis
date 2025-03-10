package com.kyang.mybatis.test;

import com.kyang.mybatis.io.Resources;
import com.kyang.mybatis.session.SqlSession;
import com.kyang.mybatis.session.SqlSessionFactory;
import com.kyang.mybatis.session.SqlSessionFactoryBuilder;
import com.kyang.mybatis.test.dao.IUserDao;
import com.kyang.mybatis.test.po.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author：wqy
 * @Description：
 * @create：2025-03-02
 */

public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);
    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 3. 测试验证
        String res = userDao.queryUserInfoById(10001);
        logger.info("测试结果：{}", res);
    }
}
