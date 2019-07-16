package ladder.utils;

public class StatusGenerator {

    private static final double STANDARD_OF_RANDOM_VALUE = 0.5;

    public static boolean get() {
        return Math.random() > STANDARD_OF_RANDOM_VALUE;
    }

}
