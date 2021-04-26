package main.java.util;

import main.java.exception.DaoException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.zip.DataFormatException;

public final class PropertyUtil {

    private static final Properties PROPERTIES = new Properties();

    private PropertyUtil() {}

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
