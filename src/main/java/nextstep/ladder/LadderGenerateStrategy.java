package nextstep.ladder;

import java.util.Random;

public class LadderGenerateStrategy implements GenerateStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }

}
