package main.java.util;

import main.java.exception.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionUtil {

    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";
    private static final String DRIVER_KEY = "db.driver";

    private ConnectionUtil() {}

    public static Connection get() {
        try {
            return DriverManager.getConnection(
                    PropertyUtil.getProperty(URL_KEY),
                    PropertyUtil.getProperty(USER_KEY),
                    PropertyUtil.getProperty(PASSWORD_KEY)
            );
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    static {
        loadDriver();
    }

    private static void loadDriver() {
        try {
            Class.forName(PropertyUtil.getProperty(DRIVER_KEY));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
