package nextstep.ladder.mock;

import ladder.domain.moveStrategy.Shift;

public class BooleanGenerator implements Shift {

    private final boolean input;

    public BooleanGenerator(boolean input) {
        this.input = input;
    }

    @Override
    public boolean next() {
        return input;
    }
}
