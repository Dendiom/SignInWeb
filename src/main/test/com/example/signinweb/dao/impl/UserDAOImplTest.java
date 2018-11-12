package com.example.signinweb.dao.impl;

import com.example.signinweb.bean.User;
import com.example.signinweb.dao.UserDAO;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDAOImplTest {

    private User user = new User();
    private UserDAO userDAO = new UserDAOImpl();

    {
        user.setUsername("TestUserOne");
        user.setPassword("123456");
        user.setSex(false);
        user.setNickname("NickName");
        user.setMail("123@qq.com");
        user.setPhone("13547678974");
        user.setGrade("研一");
    }

    @Test
    public void test() {
        try {
            User currentUser = null;

            System.out.println("Test: insertUser");
            Long id = userDAO.insertUser(user.getUsername(), user.getPassword());
            user.setId(id);
            assertNotNull(user.getId());

            System.out.println("Test: getUserById");
            currentUser = userDAO.getUserById(user.getId());
            assertNotNull(currentUser);
            assertEquals(currentUser.getUsername(), user.getUsername());
            assertEquals(currentUser.getPassword(), user.getPassword());

            System.out.println("Test: updateUser");
            userDAO.updateUser(user);
            currentUser = userDAO.getUserById(user.getId());
            System.out.println(currentUser);
            assertEquals(currentUser.getSex(), user.getSex());
            assertEquals(currentUser.getGrade(), user.getGrade());

            System.out.println("Test: getUserByUsername");
            currentUser = userDAO.getUserByUsername(user.getUsername());
            System.out.println(currentUser);
            assertEquals(currentUser.getNickname(), user.getNickname());
            assertEquals(currentUser.getMail(), user.getMail());
            assertEquals(currentUser.getPhone(), user.getPhone());

            System.out.println("Test: deleteUserById");
            userDAO.deleteUserById(user.getId());
            currentUser = userDAO.getUserById(user.getId());
            assertNull(currentUser);
        } catch (SQLException e) {
            e.printStackTrace();
            fail("SQL Exception");
        }
    }
}