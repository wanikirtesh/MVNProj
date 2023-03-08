package com.sbn.util;

import java.util.ResourceBundle;

public class TestConfigReader {
    public static final ResourceBundle rb = ResourceBundle.getBundle("testconfig");

    public static String getValue(String key,String defaultValue){
        if(rb.containsKey(key))
        return rb.getString(key);
        return defaultValue;
    }
    public static String getValue(String key){
        return rb.getString(key);
    }
}
