package ladder.domain.ns.generator;

import ladder.domain.interfaces.generator.CrossGenerator;

import java.util.Random;

public class RandomCrossGenerator implements CrossGenerator {

    public static final Random RANDOM = new Random();

    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }
}
