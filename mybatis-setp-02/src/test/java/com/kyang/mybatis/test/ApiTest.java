package com.kyang.mybatis.test;


import com.kyang.mybatis.binding.MapperRegistry;
import com.kyang.mybatis.SqlSession;
import com.kyang.mybatis.SqlSessionFactory;
import com.kyang.mybatis.defaults.DefaultSqlSessionFactory;
import com.kyang.mybatis.test.dao.ISchoolDao;
import com.kyang.mybatis.test.dao.IUserDao;
import org.junit.Test;

/**
 * @ Author：wqy
 * @ Description：
 * @ create：2025-03-01 14:27
 */

public class ApiTest {

    @Test
    public void test_mapper_proxy_factory() {
        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.addMappers("com.kyang.mybatis.test.dao");

        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        ISchoolDao schoolDao = sqlSession.getMapper(ISchoolDao.class);

        System.out.println(userDao.getUserByName("kyang"));

        System.out.println(schoolDao.getSchoolName(1));

    }
}
