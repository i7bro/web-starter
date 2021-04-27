package main.java.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;

@UtilityClass
public class ConnectionUtil {

    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";
    private static final String DRIVER_KEY = "db.driver";

    @SneakyThrows
    public static Connection get() {
            return DriverManager.getConnection(
                    PropertyUtil.getProperty(URL_KEY),
                    PropertyUtil.getProperty(USER_KEY),
                    PropertyUtil.getProperty(PASSWORD_KEY));
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
