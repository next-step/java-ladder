package com.ladder.utils;

public class AssertUtils {

    public static void checkNull(String object) {
        assert !(object == null || object.trim().isEmpty());
    }
}
