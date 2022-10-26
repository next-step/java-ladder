package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineGenerator implements LineGenerator {
    private static final Random random = new Random();

    @Override
    public Line create(int lineLength) {
        Line firstPointLine = createFirstPointLine();
        if (!isMultiPoints(lineLength)) {
            return firstPointLine;
        }
        return createAfterSecondPoints(firstPointLine, lineLength - 1);
    }

    private Line createAfterSecondPoints(Line line, int pointCount) {
        Line addedLine = line;
        while (pointCount > 0) {
            pointCount--;
            boolean nextPoint = addedLine.isLastPointTrue() ? false : getRandomBoolean();
            addedLine = addedLine.addPoint(nextPoint);
        }
        return addedLine;
    }

    private Line createFirstPointLine() {
        boolean firstPoint = createFirstPoint();
        List<Boolean> points = new ArrayList<>(List.of(firstPoint));
        return new Line(points);
    }

    private boolean isMultiPoints(int lineLength) {
        return lineLength > 1;
    }

    private boolean createFirstPoint() {
        return getRandomBoolean();
    }

    private boolean getRandomBoolean() {
        return random.nextBoolean();
    }
}
