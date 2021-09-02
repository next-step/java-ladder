package ladderrefactoring.domain.ladder;

import ladderrefactoring.strategy.LineStrategy;

import java.util.*;

public class Line {

    public static final String EXIST_TRUE_REPETITION = "연속된 사다리가 존재 합니다.";

    private final List<Boolean> points = new ArrayList<>();
    private final List<Point> points2 = new ArrayList<>();
    private int[] checkPointArr;
    private int[] movedPositionArr;


    public Line(int widthOfLadder, LineStrategy lineStrategy) {
        initLine(widthOfLadder, lineStrategy);
        initLine2(widthOfLadder, lineStrategy);
    }

    private void initLine(int widthOfLadder, LineStrategy lineStrategy) {
        for (int i = 0; i < widthOfLadder; i++) {
            points.add(lineStrategy.create());
        }
    }

    private void initLine2(int widthOfLadder, LineStrategy lineStrategy) {
        Point currentPoint = Point.first(lineStrategy.create());
        points2.add(currentPoint);

        for (int i = 0; i < widthOfLadder-1; i++) {
            currentPoint = Point.of(currentPoint, lineStrategy.create());
            points2.add(currentPoint);
        }

        points2.add(Point.last(currentPoint));
    }

    public List<Boolean> points() {
        return Collections.unmodifiableList(points);
    }

    public int movePosition2(int currentPosition) {
        Point point = points2.get(currentPosition);
        return point.move();
    }

    public int movePosition(int currentPosition) {
        checkPointArr = new int[]{leftPointOf(currentPosition), rightPointOf(currentPosition)};
        movedPositionArr = new int[]{moveLeft(currentPosition), moveRight(currentPosition)};

        for (int i = 0; i < checkPointArr.length; i++) {
            currentPosition = checkDirectionAndMove(currentPosition, i);
            continue;
        }

        return currentPosition;
    }

    private int checkDirectionAndMove(int currentPosition, int i) {
        if (checkPointArr[i] < 0 || checkPointArr[i] >= points.size() || !points.get(checkPointArr[i])) {
            return currentPosition;
        }

        return movedPositionArr[i];
    }

    private int moveRight(int currentPosition) {
        return currentPosition + 1;
    }

    private int moveLeft(int currentPosition) {
        return currentPosition - 1;
    }

    private int rightPointOf(int currentPosition) {
        return currentPosition;
    }

    private int leftPointOf(int currentPosition) {
        return currentPosition - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points) && Objects.equals(points2, line.points2) && Arrays.equals(checkPointArr, line.checkPointArr) && Arrays.equals(movedPositionArr, line.movedPositionArr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(points, points2);
        result = 31 * result + Arrays.hashCode(checkPointArr);
        result = 31 * result + Arrays.hashCode(movedPositionArr);
        return result;
    }
}
