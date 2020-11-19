package nextstep.ladder.util;

public class RandomRightDirectionGenerator {
    private static final double PROBABILTY_HAVING_POINT = 0.5;

    public static boolean hasRight() {
        return Math.random() > PROBABILTY_HAVING_POINT;
    }
}
