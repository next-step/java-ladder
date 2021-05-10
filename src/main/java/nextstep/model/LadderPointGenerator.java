package nextstep.model;

import java.util.Random;

public class LadderPointGenerator {
    public static Boolean generatePoint() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
