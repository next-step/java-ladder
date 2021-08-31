package ladder.domain;

import ladder.exception.LineCountException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random RANDOM = new Random();
    private static final int MIN_LINE_COUNT = 1;

    private final List<Boolean> points;

    public Line (int count) {
        validateCount(count);
        List<Boolean> points = new ArrayList<>();

        if (count > 1) {
            this.points = generatePoints(points, count);
            return;
        }

        this.points = points;
    }

    private List<Boolean> generatePoints(List<Boolean> points, int count) {
        points.add(RANDOM.nextBoolean());
        for (int i = 1; i < count - 1; i++) {
            boolean point = RANDOM.nextBoolean();
            if (points.get(i - 1) && point) {
                points.add(false);
                continue;
            }
            points.add(point);
        }
        return points;
    }

    private void validateCount(int countOfPerson) {
        if (countOfPerson < MIN_LINE_COUNT) {
            throw new LineCountException();
        }
    }

    public int getAfterPosition(int position) {
        if (checkBefore(position)) {
            return position - 1;
        }
        if (checkAfter(position)) {
            return position + 1;
        }
        return position;
    }

    private boolean checkBefore(int position) {
        try {
            return points.get(position - 1);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean checkAfter(int position) {
        try {
            return points.get(position);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
