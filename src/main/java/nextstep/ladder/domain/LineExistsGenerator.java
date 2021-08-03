package nextstep.ladder.domain;

import java.util.Random;

public class LineExistsGenerator {

    private static final Random RANDOM = new Random();

    public static boolean generate(boolean prevLineExists) {
        if (prevLineExists) {
            return false;
        }

        return RANDOM.nextBoolean();
    }
}
