package nextstep.ladder.domain.generator;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public boolean getBoolean() {
        return RANDOM.nextBoolean();
    }

}
