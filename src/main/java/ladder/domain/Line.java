package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, CreateStrategy createStrategy) {
        IntStream.range(0, countOfPerson)
                .forEach(index -> addHorizontal(index, countOfPerson - 1, createStrategy));
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

    private void addHorizontal(int index, int max, CreateStrategy createStrategy) {
        if (isAvailableCreate(index, max)) {
            points.add(isCreate(createStrategy));
            return;
        }
        points.add(false);
    }

    private boolean isAvailableCreate(int index, int max) {
        if (index == 0) {
            return true;
        }
        if (index == max) {
            return false;
        }
        return !isPreviousCreated(index);
    }

    private boolean isCreate(CreateStrategy strategy) {
        return strategy.create();
    }

    private boolean isPreviousCreated(int index) {
        return points.get(index - 1);
    }

    public int move(int index) {
        if (isAbleToMoveLeft(index)) {
            return index - 1;
        }
        if (isAbleToMoveRight(index)) {
            return index + 1;
        }
        return index;
    }

    private boolean isAbleToMoveLeft(int index) {
        if (index == 0) {
            return false;
        }
        return !points.get(index) && isPreviousCreated(index);
    }

    private boolean isAbleToMoveRight(int index) {
        if (index == points.size() - 1) {
            return false;
        }
        return points.get(index) && !isNextCreated(index);
    }

    private boolean isNextCreated(int index) {
        return points.get(index + 1);
    }
}
