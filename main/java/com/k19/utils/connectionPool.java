package com.k19.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.activation.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class connectionPool {

    private static connectionPool pool = null;
    private static DataSource dataSource = null;

    private connectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/shank");
        } catch (NamingException e) {
            System.out.println(e);
        }
    }

    public static synchronized connectionPool getInstance() {
        if (pool == null) {
            pool = new connectionPool();
        }
        return pool;
    }

    public Connection getConnection() {
        return ((connectionPool) dataSource).getConnection();
    }

    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
