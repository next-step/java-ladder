package nextstep.ladder.domain;

import java.util.Random;

/**
 * Created by wyparks2@gmail.com on 2019-06-29
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class RandomBooleanGenerator {
    private static final Random RANDOM = new Random();

    private RandomBooleanGenerator() {
    }

    public static boolean generate() {
        return RANDOM.nextBoolean();
    }
}
