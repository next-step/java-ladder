package step4.laddergame.domain.ladder;

import java.util.Random;

public class LadderPointerRandomGenerator implements LadderPointerGenerator {

    private final Random random = new Random();

    @Override
    public Boolean generatePoint() {
        return random.nextBoolean();
    }
}
