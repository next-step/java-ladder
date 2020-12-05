package nextstep.ladder.mock;

import nextstep.ladder.util.pointsgenerator.PointsGenerator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MockPointsGenerator implements PointsGenerator {
    private final List<List<Boolean>> mockPoints;
    private Iterator<List<Boolean>> mockPointsIterator;
    private Iterator<Boolean> mockBooleanIterator;

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
    public boolean generatePoint() {
        if (mockPointsIterator == null || !mockPointsIterator.hasNext()) {
            mockPointsIterator = mockPoints.iterator();
        }

        if (mockBooleanIterator == null || !mockBooleanIterator.hasNext()) {
            mockBooleanIterator = mockPointsIterator.next().iterator();
        }

        return mockBooleanIterator.next();
    }
}
