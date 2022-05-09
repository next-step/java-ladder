package nextstep.domain;

import java.util.Random;

public class LadderLineGenerator {
    private static final Random LINE_GENERATOR = new Random();

    public static boolean generate(int range) {
        return LINE_GENERATOR.nextInt(range) > 0;
    }

}
