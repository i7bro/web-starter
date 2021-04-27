package main.java.util;

import lombok.experimental.UtilityClass;
import main.java.exception.DaoException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class PropertyUtil {

    private static final Properties PROPERTIES = new Properties();

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

    static {
        loadUtil();
    }

    private static void loadUtil() {
        try (InputStream stream =
                     PropertyUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(stream);
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }
}
