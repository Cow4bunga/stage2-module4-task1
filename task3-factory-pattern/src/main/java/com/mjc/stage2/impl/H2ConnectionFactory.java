package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;
import org.h2.command.ddl.CreateTable;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    private static final String URL;
    private static final String PASS;
    private static final String NAME;

    static {
        Properties properties = new Properties();
        try {
            properties.load(H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties"));
            Class.forName(properties.getProperty("jbdc_driver"));
            URL = properties.getProperty("db_url");
            NAME = properties.getProperty("user");
            PASS = properties.getProperty("password");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Connection createConnection() {
        try {
            return DriverManager.getConnection(URL, NAME, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

