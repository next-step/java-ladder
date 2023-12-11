package nextstep.ladder.domain;

import java.util.Random;

public class StepFactory {
    private boolean current;

    private StepFactory(boolean current) {
        this.current = current;
    }

    public static StepFactory first(boolean flag) {
        return new StepFactory(flag);
    }

    public static StepFactory first() {
        return new StepFactory(new Random().nextBoolean());
    }

    public boolean next() {
        if (current) {
            this.current = false;
            return false;
        }
        this.current = new Random().nextBoolean();
        return this.current;
    }

    public boolean current() {
        return current;
    }
}
