package nextstep.ladder.domain;

public class RandomNumberGenerator {
    private static final int BOUND = 20;
    private static final java.util.Random random = new java.util.Random();

    public static int generate() {
        return random.nextInt(BOUND);
    }
}
