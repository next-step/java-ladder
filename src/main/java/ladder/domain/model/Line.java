package ladder.domain.model;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final Random RANDOM = new Random();
    private static final int RANGE_START = 0;
    private static final int ZERO = 0;
    private Points points = new Points();


    public void calculatorLine(int countOfPerson) {
        int rangeEnd = countOfPerson - 1;
        IntStream.range(RANGE_START, rangeEnd)
                .forEach(count -> {
                    if (count == ZERO || !points.getPoints().get(count - 1)) {
                        points.connectLine(() -> RANDOM.nextBoolean());
                        return;
                    }
                    points.connectLine(() -> false);
                });
    }

    public boolean isPointFullRight(int result) {
        return result >= points.getPoints().size();
    }

    public boolean isPointFullLeft(int result) {
        return result <= 0;
    }

    public boolean isRightConnect(int point) {
        return getLine().get(point);
    }

    public boolean isLeftConnect(int point) {
        return getLine().get(point - 1);
    }

    public List<Boolean> getLine() {
        return points.getPoints();
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points.getPoints() +
                '}';
    }
}
