package com.example.signinweb.dao;

import com.example.signinweb.bean.User;

import java.sql.SQLException;

public interface UserDAO {

    long insertUser(String username, String password) throws SQLException;

    void updateUser(User user) throws SQLException;

    User getUserById(long id) throws SQLException;

    User getUserByUsername(String username) throws SQLException;

    void deleteUserById(long id) throws SQLException;
}
