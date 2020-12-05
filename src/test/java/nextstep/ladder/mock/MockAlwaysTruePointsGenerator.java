package nextstep.ladder.mock;

import nextstep.ladder.util.pointsgenerator.PointsGenerator;

public class MockAlwaysTruePointsGenerator implements PointsGenerator {
    @Override
    public boolean generatePoint() {
        return true;
    }
}
