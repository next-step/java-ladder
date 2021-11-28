package nextstep.step2.vo;

import java.util.Random;

public class RandomBooleanGenerateStrategy implements BooleanGenerateStrategy {

    private static final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
