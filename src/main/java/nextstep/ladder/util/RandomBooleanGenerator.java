package nextstep.ladder.util;

import java.util.Random;

public class RandomBooleanGenerator {
    private static final Random random = new Random();

    public static Boolean generate(){
        return random.nextBoolean();
    }
}
