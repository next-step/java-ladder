package nextstep.ladder.util;

public class RandomRange {
    private static final double RANDOM_TRUE_STANDARD = 0.5;

    private RandomRange() {
        throw new AssertionError();
    }

    public static boolean getRandomValue() {
        return Math.random() < RANDOM_TRUE_STANDARD;
    }
}
