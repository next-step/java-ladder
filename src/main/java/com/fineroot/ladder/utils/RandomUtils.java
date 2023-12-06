package com.fineroot.ladder.utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class RandomUtils {

    private RandomUtils(){
        throw new IllegalArgumentException(ExceptionMessage.UTILITY_CLASS.getMessage());
    }

    public static Boolean[] getBooleanArray(final int size){
        return Stream.generate(()->ThreadLocalRandom.current().nextBoolean()).limit(size).toArray(Boolean[]::new);
    }
}
