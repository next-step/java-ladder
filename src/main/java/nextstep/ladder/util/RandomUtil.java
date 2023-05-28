package nextstep.ladder.util;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    public static int generator(int number) {
        return random.nextInt(number);
    }

}
