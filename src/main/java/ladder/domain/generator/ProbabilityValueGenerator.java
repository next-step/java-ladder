package ladder.domain.generator;

import java.util.Random;

public class ProbabilityValueGenerator implements ValueGenerator {
    private double probability;
    private Random random = new Random();

    public ProbabilityValueGenerator(double probability) {
        this.probability = probability;
    }

    @Override
    public boolean generateValue() {
        return random.nextDouble() <= probability;
    }
}