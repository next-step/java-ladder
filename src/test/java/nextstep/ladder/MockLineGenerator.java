package nextstep.ladder;

import nextstep.ladder.model.LineGenerator;

public class MockLineGenerator implements LineGenerator {
    @Override
    public boolean generate() {
        return true;
    }
}
