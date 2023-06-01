package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final String CONSECUTIVE_LINES_ARE_NOT_ALLOWED = "연속된 가로줄은 허용하지 않습니다.";

    private static final int START_INDEX = 1;

    private final List<Boolean> points;

    public Line(List<Boolean> initializedPoints) {
        validatePoints(initializedPoints);
        this.points = initializedPoints;
    }

    private void validatePoints(List<Boolean> points) {
        boolean hasConsecutiveLines = IntStream.range(START_INDEX, points.size())
                .anyMatch(index -> judgeIfAllTwoConsecutivePointsHaveLine(points, index));
        if (hasConsecutiveLines) {
            throw new IllegalStateException(CONSECUTIVE_LINES_ARE_NOT_ALLOWED);
        }
    }

    private boolean judgeIfAllTwoConsecutivePointsHaveLine(List<Boolean> points, int index) {
        return points.get(index - 1) && points.get(index);
    }

    public static List<Boolean> initializePoints(int countOfPerson, MakePointsStrategy makePointsStrategy) {
        return makePointsStrategy.makePoints(countOfPerson);
    }

    public int findNextIndex(int currentIndex) {
        if (isMovingToLeftPossible(currentIndex)) {
            return currentIndex - 1;
        }
        if (isMovingToRightPossible(currentIndex)) {
            return currentIndex + 1;
        }
        return currentIndex;
    }

    private boolean isMovingToRightPossible(int currentIndex) {
        return currentIndex < points.size() && points.get(currentIndex);
    }

    private boolean isMovingToLeftPossible(int currentIndex) {
        return currentIndex > 0 && points.get(currentIndex - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
