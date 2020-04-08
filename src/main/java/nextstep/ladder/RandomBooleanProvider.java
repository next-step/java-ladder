package nextstep.ladder;

public class RandomBooleanProvider {
    private static double RANDOM_RATE = 0.5;

    private RandomBooleanProvider() {}

    public static boolean getRandomBoolean() {
        return Math.random() < RANDOM_RATE;
    }
}
