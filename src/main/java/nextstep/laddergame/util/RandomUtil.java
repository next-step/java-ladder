package nextstep.laddergame.util;

import java.util.Random;

public class RandomUtil {

    public static boolean halfAndHalfBoolean() {
        return new Random().nextBoolean();
    }

    public static int randomIndex(int listSize) {
        return new Random().nextInt(listSize);
    }
}