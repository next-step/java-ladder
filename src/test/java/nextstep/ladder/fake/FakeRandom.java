package nextstep.ladder.fake;

import java.util.Random;

public class FakeRandom extends Random {
    private boolean value;

    public FakeRandom(boolean value) {
        this.value = value;
    }

    @Override
    public boolean nextBoolean() {
        return this.value;
    }
}
