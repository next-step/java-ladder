package com.seok2.global.util;

public class StringUtils {

    private static final String DEFAULT_SEPARATOR = ",";

    private StringUtils (){
    }

    public static String [] split(String str) {
        return str.split(DEFAULT_SEPARATOR);
    }

    public static String [] split(String str, String separator) {
        return str.split(separator);
    }

}
