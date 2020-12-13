package my.project.step4.domain;

import java.util.Random;

public class LadderPointGenerator {
    public static final int ZERO = 0;
    public static final int EVEN = 2;

    public static Bridge generatePoint() {
        return new Random().nextInt(EVEN) % EVEN == ZERO ? Bridge.CONNECTED : Bridge.NONE;
    }

    private LadderPointGenerator() {
    }
}
