package com.example.signinweb.service.impl;

import com.example.signinweb.bean.Result;
import com.example.signinweb.bean.User;
import com.example.signinweb.dao.UserDAO;
import com.example.signinweb.dao.impl.UserDAOImpl;
import com.example.signinweb.enums.Code;
import com.example.signinweb.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    UserDAO userDAO = new UserDAOImpl();

    public Result register(String username, String password) {
        try {
            User user = userDAO.getUserByUsername(username);
            if (user != null) {
                return new Result<>(Code.USER_HAS_ALREADY_REGISTERED, "用户已存在");
            }

            long id = userDAO.insertUser(username, password);
            return new Result<>(Code.SUCCESS, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return new Result<>(Code.MYSQL_ERROR, "mysql error");
        }
    }

    public Result login(String username, String password) {
        try {
            User user = userDAO.getUserByUsername(username);
            if (user == null) {
                return new Result<>(Code.USER_NOT_REGISTERED, "用户未注册");
            }

            if (password.equals(user.getPassword())) {
                return new Result<>(Code.SUCCESS, user);
            }

            return new Result<>(Code.PASSWORD_ERROR, "密码错误");
        } catch (SQLException e) {
            e.printStackTrace();
            return new Result<>(Code.MYSQL_ERROR, "mysql error");
        }
    }

    public Result perfectInfo(User user) {
        try {
            userDAO.updateUser(user);
            return new Result<>(Code.SUCCESS, "");
        } catch (SQLException e) {
            e.printStackTrace();
            return new Result<>(Code.MYSQL_ERROR, "mysql error");
        }
    }

    public Result getUserInfo(long id) {
        try {
            User user = userDAO.getUserById(id);
            if (user != null) {
                return new Result<>(Code.SUCCESS, user);
            }

            return new Result<>(Code.MYSQL_ERROR, null);
        } catch (SQLException e) {
            e.printStackTrace();
            return new Result<>(Code.MYSQL_ERROR, "mysql error");
        }
    }
}
