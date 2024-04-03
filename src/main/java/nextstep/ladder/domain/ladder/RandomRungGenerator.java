package nextstep.ladder.domain.ladder;

import java.util.Random;

public class RandomRungGenerator implements RungGenerateStrategy {
    private static final Random RANDOM = new Random();

    @Override
    public boolean addable() {
        return RANDOM.nextBoolean();
    }

}
