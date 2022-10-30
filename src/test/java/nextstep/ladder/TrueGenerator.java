package nextstep.ladder;

import nextstep.ladder.strategy.BooleanGenerator;

public class TrueGenerator implements BooleanGenerator {

    @Override
    public boolean generate() {
        return true;
    }
}
