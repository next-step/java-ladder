package step4.domain;

import java.util.Random;

public class LadderPointGenerator {

    private static final Random RD = new Random();

    public static boolean generatePoint() {
        return RD.nextBoolean();
    }
}
