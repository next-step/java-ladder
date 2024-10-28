package nextstep.ladder.v2;

import nextstep.ladder.v2.model.PointGenerator;

public class MockPointGenerator implements PointGenerator {
    @Override
    public boolean generate(boolean prev) {
        return !prev;
    }
}
