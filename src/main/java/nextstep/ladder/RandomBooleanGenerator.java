package nextstep.ladder;

import java.util.Random;

/**
 * Created by wyparks2@gmail.com on 2019-06-29
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class RandomBooleanGenerator {
    private static final Random RANDOM = new Random();
    private static final int TRUE_CONDITION = 1;
    private static final int BOUND = 2;

    private RandomBooleanGenerator() {
    }

    public static boolean generate() {
        return RANDOM.nextInt(BOUND) == TRUE_CONDITION;
    }
}
