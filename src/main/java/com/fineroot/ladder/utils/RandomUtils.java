package com.fineroot.ladder.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private RandomUtils(){
        throw new IllegalArgumentException(ExceptionMessage.UTILITY_CLASS.getMessage());
    }

    public static boolean getBoolean(){
        return ThreadLocalRandom.current().nextBoolean();
    }
}
