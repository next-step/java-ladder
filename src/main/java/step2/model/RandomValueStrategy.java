package step2.model;

import java.util.Random;

public class RandomValueStrategy implements ValueStrategy {
    @Override
    public boolean generateValue() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
