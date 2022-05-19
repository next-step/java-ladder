package nextstep.ladder.utils;

import java.util.Random;

public final class LadderPointGenerator {

    private LadderPointGenerator() { }

    public static boolean generatePoint() {
        return new Random().nextBoolean();
    }

}
