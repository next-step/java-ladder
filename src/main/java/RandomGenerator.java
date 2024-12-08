import java.util.Random;

public class RandomGenerator {
    private final Random random;

    public RandomGenerator() {
        random = new Random();
    }

    public boolean rand() {
        return this.random.nextInt() % 5 >= 3; // 40% for bridge
    }
}
