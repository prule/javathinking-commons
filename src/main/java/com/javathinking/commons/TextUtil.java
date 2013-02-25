package com.javathinking.commons;

import org.apache.commons.lang.StringUtils;

import java.util.Properties;

/**
 * @author prule
 */
public class TextUtil {

    private static final String START = "${";
    private static final String END = "}";

    public static String replace(String input, Properties properties) {
        for (Object key : properties.keySet()) {
            StringUtils.replace(input, START + key + END, properties.getProperty((String) key));
        }
        return input;
    }
}
