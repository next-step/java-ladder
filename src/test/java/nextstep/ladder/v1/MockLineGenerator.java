package nextstep.ladder.v1;

import nextstep.ladder.v1.model.LineGenerator;

public class MockLineGenerator implements LineGenerator {
    @Override
    public boolean generate() {
        return true;
    }
}
