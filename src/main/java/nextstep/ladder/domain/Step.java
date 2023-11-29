package nextstep.ladder.domain;

import java.util.Random;

public class Step {
    private boolean step;

    public Step() {
        this(false);
    }
    public Step(boolean step) {
        this.step = step;
    }

    public boolean next() {
        if (step) {
            this.step = false;
            return false;
        }
        this.step = new Random().nextBoolean();
        return this.step;
    }
}
