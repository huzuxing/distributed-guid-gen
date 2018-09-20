package com.id.generate.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by huzuxing on 2017/7/10.
 */
public class PropertyUtils {

    private static final Properties properties;

    static {
        properties = new Properties();
        InputStream is = null;
        try {
            is = PropertyUtils.class.getResourceAsStream("/guid-gen.properties");
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    ;
                }
            }
        }
    }

    public static String get(String name) {
        return properties.getProperty(name);
    }

}
