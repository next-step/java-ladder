import java.util.Random;

public class RandomGenerator {
    private final Random random;

    public RandomGenerator() {
        random = new Random();
    }

    public DotType rand() {
        return this.random.nextInt() % 2 == 0 ? DotType.EMPTY : DotType.BRIDGE;
    }
}
