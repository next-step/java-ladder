import java.util.Random;

public class RandomGenerator {
    private final Random random;

    public RandomGenerator() {
        random = new Random();
    }

    public DotType rand() {
        return this.random.nextInt() % 5 < 3 ? DotType.EMPTY : DotType.BRIDGE; // 40% for Bridge
    }
}
