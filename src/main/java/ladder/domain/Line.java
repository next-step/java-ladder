package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final int INDEX_DIFFERENCE = 1;
    private final List<Boolean> point;

    public Line(int countOfPerson) {
        this.point = new ArrayList<>();
        int pointCount = getPointCount(countOfPerson);

        for (int index = 0; index < pointCount; index++) {
            this.point.add(generatePointValue(index));
        }
    }

    private int getPointCount(int countOfPerson) {
        return countOfPerson - INDEX_DIFFERENCE;
    }

    private boolean generatePointValue(int index) {
        if (isPreviousPointExist(index)) {
            return false;
        }

        return new Random(System.currentTimeMillis()).nextBoolean();
    }

    private boolean isPreviousPointExist(int index) {
        return index != 0 && this.point.get(index - INDEX_DIFFERENCE);
    }

    public boolean isPointExist(int index) {
        return this.point.get(index);
    }

    public List<Boolean> getPoint() {
        return new ArrayList<>(this.point);
    }
}
