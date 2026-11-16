package com.qa.utils;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;
public class ConfigReader {
    private static Properties properties;

    //Crea un objeto Properties y guardalo en nuestra variable properties
    static {
        properties = new Properties();
        InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Error al cargar config.properties: " + e.getMessage());
        }
    }
        public static String get(String clave) {
            return properties.getProperty(clave);

    }

}
