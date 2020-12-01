package nextstep.ladder.mock;

import nextstep.ladder.util.pointsgenerator.PointsGenerator;

import java.util.List;

public class MockAlwaysTruePointsGenerator implements PointsGenerator {
    @Override
    public List<Boolean> getPoints(int pointsSize) {
        return null;
    }

    @Override
    public boolean generatePoint() {
        return true;
    }
}
