package nextstep.ladder.mock;

import nextstep.ladder.util.pointsgenerator.PointsGenerator;

import java.util.Arrays;
import java.util.List;

public class MockPointsGenerator implements PointsGenerator {
    private final List<List<Boolean>> mockPoints;
    private int index = 0;

    public MockPointsGenerator() {
        mockPoints = Arrays.asList(
                Arrays.asList(true, false, true),
                Arrays.asList(false, true, false),
                Arrays.asList(true, false, false),
                Arrays.asList(false, true, false),
                Arrays.asList(true, false, true)
        );
    }

    @Override
    public List<Boolean> getPoints(int pointsSize) {
        return mockPoints.get(index++);
    }
}
