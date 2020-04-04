package nextstep.ladder;

public class RandomBooleanProvider {
    private static double RANDOM_RATE = 0.5;
    private static RandomBooleanProvider randomBooleanProvider;

    private RandomBooleanProvider() {
        this.randomBooleanProvider = new RandomBooleanProvider();
    }

    public static RandomBooleanProvider getInstance() {
        if(randomBooleanProvider == null) {
            randomBooleanProvider = new RandomBooleanProvider();
        }
        return randomBooleanProvider;
    }

    public static boolean getRandomBoolean() {
        return Math.random() < RANDOM_RATE;
    }
}
