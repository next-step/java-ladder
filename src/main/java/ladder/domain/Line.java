package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, CreateStrategy createStrategy) {
        IntStream.range(0, countOfPerson)
                .forEach(index -> addHorizontal(countOfPerson, createStrategy));
    }

    public int getSize() {
        return points.size();
    }

    public boolean getPoint(int index) {
        return points.get(index);
    }

    private void addHorizontal(int countOfPerson, CreateStrategy createStrategy) {
        if (isAvailableCreate(points, countOfPerson)) {
            points.add(isCreate(createStrategy));
            return;
        }
        points.add(false);
    }

    private static boolean isAvailableCreate(List<Boolean> points, int countOfPerson) {
        if (points.isEmpty()) {
            return true;
        }
        if (isLastPoint(points, countOfPerson)) {
            return false;
        }
        return !isPreviousCreated(points);
    }

    private static boolean isCreate(CreateStrategy strategy) {
        return strategy.create();
    }

    private static boolean isLastPoint(List<Boolean> points, int countOfPerson) {
        return points.size() == countOfPerson - 1;
    }

    private static Boolean isPreviousCreated(List<Boolean> points) {
        return points.get(points.size() - 1);
    }


}
