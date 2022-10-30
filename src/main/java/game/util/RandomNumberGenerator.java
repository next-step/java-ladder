package game.util;

public class RandomNumberGenerator {
    public static int randomNumber(int bound) {
        return SingletonRandom.getInstance().nextInt(bound);
    }

    public static boolean randomBoolean() {
        return SingletonRandom.getInstance().nextBoolean();
    }
}
