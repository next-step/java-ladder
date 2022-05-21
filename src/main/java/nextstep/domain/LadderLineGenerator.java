package nextstep.domain;

import java.util.Random;

public class LadderLineGenerator {
    private static final Random LINE_GENERATOR = new Random();

    public static boolean generatePoint() {
        return LINE_GENERATOR.nextBoolean();
    }

}
