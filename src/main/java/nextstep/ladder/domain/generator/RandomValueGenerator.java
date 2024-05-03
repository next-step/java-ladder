package nextstep.ladder.domain.generator;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator {

    private final static Random random = new Random();
    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
