package utill;

import model.Order;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static final String CONFIG_PATH = "src/main/resources/config.properties";
    private static final String ORDER_PATH = "src/main/resources/order.properties";

    private static String getValue(String patToProperty, String key){
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream(patToProperty);
            property.load(fis);
            return property.getProperty(key);
        } catch (IOException e) {
            System.err.println("Error to get property by the key : " + key);
            return null;
        }
    }

    public static String getConfigValue(String key){
        return getValue(CONFIG_PATH, key);
    }

    public static String getOrderValue(String key){
        return getValue(ORDER_PATH, key);
    }

}
