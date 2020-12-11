package utils;

import java.util.Random;

public class RandomUtils {
    private final static Random RANDOM = new Random();

    public static boolean trueOrFalse(){
        return RANDOM.nextDouble() >= 0.5;
    }
}
