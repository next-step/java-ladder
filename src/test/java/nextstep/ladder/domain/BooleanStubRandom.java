package nextstep.ladder.domain;

import java.util.Random;

public class BooleanStubRandom extends Random {

    private final boolean nextBoolean;

    public BooleanStubRandom(boolean nextBoolean) {
        this.nextBoolean = nextBoolean;
    }

    @Override
    public boolean nextBoolean() {
        return nextBoolean;
    }
}
