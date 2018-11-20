package ladder.utils;

import java.util.Random;

public class LadderPointGenerator {

    public static boolean generatePoint() {
        return new Random().nextBoolean();
    }
}
