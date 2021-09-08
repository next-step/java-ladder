package nextstep.ladder;

import java.util.Random;

public class RandomBooleanGenerator {

    private static final Random RANDOM = new Random();

    public static boolean generate() {
        return RANDOM.nextBoolean();
    }

}
