package com.example.signinweb.lib.mysql;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javafx.scene.shape.CircleBuilder;

import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Helper {

    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    public static ComboPooledDataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close() {
        dataSource.close();
    }
}
