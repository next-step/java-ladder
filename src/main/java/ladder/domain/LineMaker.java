package ladder.domain;

import java.util.ArrayList;
import java.util.List;

class LineMaker {
    private static final int NUMBER_OF_FIRST_AND_LAST_BAR = 2;

    private List<Point> randomPoints;
    private RandomPointGenerator barGenerator = new RandomPointGenerator();

    List<Point> generatePoints(int numberOfPlayers) {
        this.randomPoints = new ArrayList<>();
        generateFirstPoint();
        generateMiddlePoints(numberOfPlayers);
        generateLastPoint();
        return randomPoints;
    }

    private void generateFirstPoint() {
        Direction direction = Direction.PASS;
        if (barGenerator.generatePoint()) {
            direction = Direction.RIGHT;
        }
        randomPoints.add(Point.makeFirstPoint(direction));
    }

    private void generateMiddlePoints(int numberOfPlayers) {
        int spaceForMiddleBars = numberOfPlayers - NUMBER_OF_FIRST_AND_LAST_BAR;
        for (int i = 0; i < spaceForMiddleBars; i++) {
            Point previousPoint = randomPoints.get(i);
            addNextPoint(previousPoint);
        }
    }

    private void addNextPoint(Point previousPoint) {
        if (previousPoint.isDirectionRight()) {
            randomPoints.add(previousPoint.makeNextPoint(Direction.LEFT));
            return;
        }
        Direction direction = Direction.PASS; //TODO: 중복 제거
        if (barGenerator.generatePoint()) {
            direction = Direction.RIGHT;
        }
        randomPoints.add(previousPoint.makeNextPoint(direction));
    }

    private void generateLastPoint() {
        int currentlyLastIndex = randomPoints.size() - 1;
        Point secondToLastPoint = randomPoints.get(currentlyLastIndex);
        randomPoints.add(secondToLastPoint.makeLastPoint());
    }

}
