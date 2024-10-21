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
        if (index < 0 || index >= points.size()) {
            throw new IllegalArgumentException("객체 범위 외의 인덱스는 허용하지 않습니다.");
        }
        return points.get(index);
    }

    public int move(int index) {
        if (isMoveLeft(index)) {
            return index - 1;
        }
        if (isMoveRight(index)) {
            return index + 1;
        }
        return index;
    }

    private void addHorizontal(int countOfPerson, CreateStrategy createStrategy) {
        if (isAvailableCreate(points, countOfPerson)) {
            points.add(isCreate(createStrategy));
            return;
        }
        points.add(false);
    }

    private boolean isAvailableCreate(List<Boolean> points, int countOfPerson) {
        if (points.isEmpty()) {
            return true;
        }
        if (isLastPoint(points, countOfPerson)) {
            return false;
        }
        return !isPreviousCreated(points);
    }

    private boolean isCreate(CreateStrategy strategy) {
        return strategy.create();
    }

    private boolean isLastPoint(List<Boolean> points, int countOfPerson) {
        return points.size() == countOfPerson - 1;
    }

    private Boolean isPreviousCreated(List<Boolean> points) {
        return points.get(points.size() - 1);
    }

    private boolean isMoveLeft(int index) {
        if (index == 0) {
            return false;
        }
        return !getPoint(index) && getPoint(index - 1);
    }

    private boolean isMoveRight(int index) {
        if (index == points.size() - 1) {
            return false;
        }
        return getPoint(index) && !getPoint(index + 1);
    }
}
