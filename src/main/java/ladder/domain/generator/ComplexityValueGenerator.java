package ladder.domain.generator;

import ladder.domain.ComplexityType;

import java.util.Random;

public class ComplexityValueGenerator implements ValueGenerator {
    private ComplexityType complexityType;
    private Random random = new Random();

    public ComplexityValueGenerator(ComplexityType complexityType) {
        this.complexityType = complexityType;
    }

    @Override
    public boolean generateValue() {
        return random.nextDouble() < complexityType.getProbabilityOfLink();
    }
}