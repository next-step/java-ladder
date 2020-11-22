package nextstep.ladder.mock;

import nextstep.ladder.util.pointsgenerator.PointsGenerator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MockPointsGenerator implements PointsGenerator {
    private final List<List<Boolean>> mockPoints;
    private int index = 0;
    private final Iterator<List<Boolean>> lineIterator;
    private Iterator<Boolean> booleanIterator;

    public MockPointsGenerator() {
        mockPoints = Arrays.asList(
                Arrays.asList(true, false, true),
                Arrays.asList(false, true, false),
                Arrays.asList(true, false, false),
                Arrays.asList(false, true, false),
                Arrays.asList(true, false, true)
        );

        lineIterator = mockPoints.iterator();
    }

    @Override
    public List<Boolean> getPoints(int pointsSize) {
        return mockPoints.get(index++);
    }

    public boolean getMockPoint() {
        if (booleanIterator == null || !booleanIterator.hasNext()) {
            booleanIterator = lineIterator.next().iterator();
        }
        return booleanIterator.next();
    }
}
