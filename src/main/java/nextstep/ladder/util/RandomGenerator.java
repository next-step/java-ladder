package nextstep.ladder.util;

import java.util.Random;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-11 20:14
 */
public class RandomGenerator {
    public static final Random RANDOM = new Random();

    public static boolean generateBoolean() {
        return RANDOM.nextBoolean();
    }
}
