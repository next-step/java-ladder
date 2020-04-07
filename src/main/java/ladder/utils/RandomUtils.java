package ladder.utils;

import java.util.Random;

public final class RandomUtils {

    private static final String NON_CREATE_MSG = "유틸 객체 생성 불가";

    private RandomUtils() {
        throw new IllegalArgumentException(NON_CREATE_MSG);
    }

    public static boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
