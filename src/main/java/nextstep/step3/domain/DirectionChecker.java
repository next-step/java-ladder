package nextstep.step3.domain;

import java.util.ArrayList;
import java.util.List;

public class DirectionChecker {
    private static final int FIRST_POSITION = 0;
    private List<Line> lines;
    private int depth;
    private int breadth;

    public DirectionChecker(List<Line> lines) {
        this.lines = lines;
        this.depth = lines.size();
        this.breadth = lines.get(FIRST_POSITION).getPoints().size();
    }

    public List<Integer> getResult() {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i <= breadth; i++) {
            resultList.add(checkDirection(FIRST_POSITION, i));
        }
        return resultList;
    }

    private int checkDirection(int depthPosition, int breadthPosition) {
        if (depthPosition == depth) {
            return breadthPosition;
        }

        List<Boolean> points = lines.get(depthPosition).getPoints();
        if (isFirstPosition(breadthPosition)) {
            if (isMoveableRight(points, breadthPosition)) {
                return moveRightLine(depthPosition, breadthPosition);
            }
            return moveNextLine(depthPosition, breadthPosition);
        }

        if (isLastPosition(breadthPosition)) {
            if (isMoveableLeft(points, breadthPosition)) {
                return moveLeftLine(depthPosition, breadthPosition);
            }
            return moveNextLine(depthPosition, breadthPosition);
        }

        if (isMoveableLeft(points, breadthPosition)) {
            return moveLeftLine(depthPosition, breadthPosition);
        }
        if (isMoveableRight(points, breadthPosition)) {
            return moveRightLine(depthPosition, breadthPosition);
        }
        return moveNextLine(depthPosition, breadthPosition);
    }

    private boolean isFirstPosition(int breadthPosition) {
        return breadthPosition == FIRST_POSITION;
    }

    private boolean isLastPosition(int breadthPosition) {
        return breadthPosition == breadth;
    }

    private boolean isMoveableLeft(List<Boolean> points, int breadthPosition) {
        return points.get(breadthPosition - 1);
    }

    private boolean isMoveableRight(List<Boolean> points, int breadthPosition) {
        return points.get(breadthPosition);
    }

    private int moveNextLine(int depthPosition, int breadthPosition) {
        return checkDirection(++depthPosition, breadthPosition);
    }

    private int moveRightLine(int depthPosition, int breadthPosition) {
        return checkDirection(++depthPosition, ++breadthPosition);
    }

    private int moveLeftLine(int depthPosition, int breadthPosition) {
        return checkDirection(++depthPosition, --breadthPosition);
    }
}
