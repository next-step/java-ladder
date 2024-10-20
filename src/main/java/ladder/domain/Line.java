package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        IntStream.range(0, countOfPerson)
                .forEach(index -> {
                    if (isAvailableCreate(points, countOfPerson)) {
                        points.add(isCreate(RandomStrategy.getInstance()));
                        return;
                    }
                    points.add(false);
                });
    }

    public static boolean isCreate(CreateStrategy strategy) {
        return strategy.create();
    }

    public static boolean isAvailableCreate(List<Boolean> points, int countOfPerson) {
        if (points.isEmpty()) {
            return true;
        }
        if (isLastPoint(points, countOfPerson)) {
            return false;
        }
        return !isPreviousCreated(points);
    }

    private static Boolean isPreviousCreated(List<Boolean> points) {
        return points.get(points.size() - 1);
    }

    private static boolean isLastPoint(List<Boolean> points, int countOfPerson) {
        return points.size() == countOfPerson - 1;
    }

    public int getSize() {
        return points.size();
    }
}
