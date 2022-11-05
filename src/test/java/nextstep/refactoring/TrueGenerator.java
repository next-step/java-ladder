package nextstep.refactoring;

import nextstep.refactoring.strategy.BooleanGenerator;

public class TrueGenerator implements BooleanGenerator {

    @Override
    public boolean generate() {
        return true;
    }
}
