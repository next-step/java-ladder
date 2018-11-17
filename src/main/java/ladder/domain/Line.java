package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

    private static final int ONE = 1;
    private static final int START_POINT = 0;

    private List<Boolean> points;

    public Line (int countOfPerson) {
        generateLine(countOfPerson);
    }

    public int generateLine(int countOfPerson) {
        points = new ArrayList<>();

        IntStream.range(0, numberOfPoints(countOfPerson))
                .forEach(i -> points.add(generateCurrentPoint(i)));

        return points.size();
    }

    boolean generateCurrentPoint(int newPosition) {
        boolean point = new Random().nextBoolean();

        if(isOverLapped(point, newPosition)) {
            point = !point;
        }

        return point;
    }

    private boolean isOverLapped(boolean newPoint, int currPosition) {
        if(currPosition == START_POINT)
            return false;

        return isEqual(newPoint, points.get(currPosition-1));
    }

    static boolean isEqual(boolean newPoint, boolean prevPoint) {
        return newPoint == prevPoint;
    }

    static int numberOfPoints(int countOfPerson) {
        return countOfPerson - ONE;
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
