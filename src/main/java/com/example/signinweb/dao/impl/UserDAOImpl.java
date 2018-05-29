package com.example.signinweb.dao.impl;

import com.example.signinweb.bean.User;
import com.example.signinweb.dao.UserDAO;
import com.example.signinweb.lib.mysql.C3p0Helper;
import com.example.signinweb.util.SQLUtil;
import javafx.util.Pair;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    public long insertUser(String username, String password) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Helper.getDataSource());
        BigInteger id = queryRunner.insert("insert into user(username, password) value(?,?)", new ScalarHandler<BigInteger>(),
                username, password);
        return id.longValue();
    }

    public void updateUser(User user) throws SQLException {
//        System.out.println(user);
        QueryRunner queryRunner = new QueryRunner(C3p0Helper.getDataSource());
        Pair<String, Object[]> sql = SQLUtil.genUpdateUserSQL(user);
        queryRunner.update(sql.getKey(), sql.getValue());

    }

    public User getUserById(long id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Helper.getDataSource());
        return queryRunner.query("select * from user where id = ?",
                new BeanHandler<User>(User.class), id);
    }

    public User getUserByUsername(String username) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3p0Helper.getDataSource());
        return queryRunner.query("select * from user where username = ?",
                new BeanHandler<User>(User.class), username);
    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();
        User user = null;
        try {
            user = userDAO.getUserByUsername("testUser");
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
