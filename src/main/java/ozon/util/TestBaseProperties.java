package ozon.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public enum TestBaseProperties {
    INSTANCE;
    private final Properties properties = new Properties();
    TestBaseProperties() {
        try {
            FileInputStream inputStream = new FileInputStream("src/test/resources/config/config.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Properties getProperties() {
        return properties;
    }
}
