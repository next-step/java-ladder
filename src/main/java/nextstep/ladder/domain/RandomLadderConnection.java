package nextstep.ladder.domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomLadderConnection implements LadderConnectionLineConditional {

    @Override
    public boolean isEnough() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
