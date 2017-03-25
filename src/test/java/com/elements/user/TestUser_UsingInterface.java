package com.elements.user;

import com.elements.user.mapper.UserMapper;
import com.elements.user.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUser_UsingInterface {

    @Test(enabled=true)
    public void TestSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // SqlSessionFactoryBuilder() -> SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // SqlSessionFactory -> SqlSession
        SqlSession session = sqlSessionFactory.openSession();
        try {
            // !!!! Calling Manner is Different
            // this is the xml manner:
            // List<User> userlist = session.selectList("com.elements.user.mapper.getAllUser");
            // this is the interface manner:
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> userlist = userMapper.getAllUser();
            System.out.println(userlist);
            Assert.assertTrue(false);
        }catch(Exception e){
            System.out.print(e);
        }finally {
            session.close();
        }
    }

    @Test(enabled=true)
    public void TestSelect() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            // !!!! Calling Manner is Different
            // this is the xml manner:
            // User user = (User) session.selectOne("com.elements.user.mapper.getUserById", "1");
            // this is the interface manner:
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.getUserById("1");

            System.out.print(user);
            Assert.assertTrue(false);
        } finally {
            session.close();
        }
    }

    @Test(enabled=false)
    public void TestInsert() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = new User();
            user.setUserName("abc");
            user.setUserEmail("aaaaa");

            // !!!! Calling Manner is Different
            // this is the xml manner:
            // session.update("com.elements.user.mapper.insert", user);
            // this is the interface manner:
            UserMapper userMapper = session.getMapper(UserMapper.class);
            int i = userMapper.insert(user);

            session.commit();
            //Assert.assertTrue(false);
        } finally {
            session.close();
        }
    }

    @Test(enabled=true)
    public void TestUpdate() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = new User();
            user.setUserId(30);
            user.setUserName("aabaa");
            user.setUserEmail("bbcbb");

            // !!!! Calling Manner is Different
            // this is the xml manner:
            // session.update("com.elements.user.mapper.update", user);
            // this is the interface manner:
            UserMapper userMapper = session.getMapper(UserMapper.class);
            int i = userMapper.update(user);

            session.commit();
            //Assert.assertTrue(false);
        } finally {
            session.close();
        }
    }
}