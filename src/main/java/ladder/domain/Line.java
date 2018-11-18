package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

    private static final int ONE = 1;
    private static final int START_POINT = 0;

    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line generateLine(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();

        IntStream.range(0, numberOfPoints(countOfPerson))
                .forEach(i -> points.add(generateCurrentPoint(i, points)));

        return new Line(points);
    }

    private static boolean generateCurrentPoint(int newPosition, List<Boolean> points) {
        boolean point = new Random().nextBoolean();

        if(newPosition == START_POINT) {
            return point;
        }

        if(isOverLapped(point, points.get(newPosition - ONE))) {
            point = !point;
        }

        return point;
    }

    static boolean isOverLapped(boolean newPoint, boolean currPosition) {

        return newPoint == currPosition;
    }

    private static int numberOfPoints(int countOfPerson) {
        return countOfPerson - ONE;
    }

    int moveToNextPoint(int currPlayerPosition) {

        int newLeftPosition = currPlayerPosition - 1;

        if(newLeftPosition > -1 && this.points.get(newLeftPosition)) {
            return newLeftPosition;
        }

        if(currPlayerPosition < this.points.size() && this.points.get(currPlayerPosition)) {
            return currPlayerPosition + 1;
        }

        return currPlayerPosition;
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder("   |");
        points.forEach(b -> str.append(pointToString(b)));

        return str.toString();
    }

    private String pointToString(boolean b) {
        if(b) {
            return "-----|";
        }

        return "     |";
    }
}
