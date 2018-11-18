package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int START_POINT = 0;

    private List<Position> points;

    public Line(List<Position> generatedPoints) {
        this.points = generatedPoints;
    }

    public static Line generateLine(int countOfPerson) {
        List<Position> generatePoints = new ArrayList<>();

        //first : 0
        generatePoints.add(Position.generateFirstPosition(START_POINT, new Random().nextBoolean()));

        // 1 ~ before last
        IntStream.range(ONE, countOfPerson - ONE)
                .forEach(i -> generatePoints.add(generateNewPosition(i, generatePoints)));

        //last : countOfPerson - 1
        generatePoints.add(Position.generateLastPosition(countOfPerson - ONE, generatePoints.get(countOfPerson - TWO)));

        return new Line(generatePoints);
    }

    private static Position generateNewPosition(int currPosition, List<Position> points) {
        boolean newPoint = new Random().nextBoolean();
        Position prevPosition = points.get(currPosition - ONE);

        if(prevPosition.isOverlapped(newPoint)) {
            newPoint = !newPoint;
        }

        return Position.generateNewPosition(currPosition, prevPosition, newPoint);
    }

    int moveToNextPoint(int position) {
        Position currPlayerPosition = this.points.get(position);

        if(currPlayerPosition.isMovableToLeft()) {
            return currPlayerPosition.moveLeft();
        }

        if(currPlayerPosition.isMovableToRight()) {
            return currPlayerPosition.moveRight();
        }

        return position;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("|");

        return str.append(
                this.points.stream()
                        .map(Position::toString)
                        .collect(Collectors.joining("|"))
        ).toString();
    }
}
