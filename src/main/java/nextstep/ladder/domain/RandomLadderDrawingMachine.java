package nextstep.ladder.domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomLadderDrawingMachine implements LadderLineDrawingMachine {

    @Override
    public boolean attemptToDraw() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
