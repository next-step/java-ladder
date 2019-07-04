package ladder.domain.ladderline;

import ladder.domain.model.Direction;
import ladder.domain.model.Index;
import ladder.domain.model.Point;

public class LadderLineRule {
    private final RandomGenerator randomGenerator;
    private Point prevPoint;
    private Index currentIndex;
    private int endIndex;

    private LadderLineRule(RandomGenerator randomGenerator, Point prevPoint, Index currentIndex, int endIndex) {
        this.randomGenerator = randomGenerator;
        this.prevPoint = prevPoint;
        this.currentIndex = currentIndex;
        this.endIndex = endIndex;
    }

    public static LadderLineRule of(RandomGenerator randomGenerator, Point prevPoint, Index currentIndex, int size) {
        return new LadderLineRule(randomGenerator, prevPoint, currentIndex, size -1);
    }

    public Point makePoint() {
        return Point.of(
                currentIndex,
                Direction.of(prevPoint.isRight(), isDrawingCondition()));
    }

    private boolean isDrawingCondition() {
        return isValidPosition() && randomGenerator.get();
    }

    private boolean isValidPosition() {
        return currentIndex.isStartIndex() || (isNoPreviousLine() && isNotEndIndex());
    }

    private boolean isNotEndIndex() {
        return !currentIndex.isSameIndex(endIndex);
    }

    private boolean isNoPreviousLine() {
        return !prevPoint.isRight();
    }
}
