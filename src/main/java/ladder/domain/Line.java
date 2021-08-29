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

    public Line (int countOfPerson) {
        validateCount(countOfPerson);

        List<Boolean> points = new ArrayList<>();

        points.add(RANDOM.nextBoolean());

        for (int i = 0; i < countOfPerson - 2; i++) {
            boolean point = RANDOM.nextBoolean();
            if (points.get(i) && point) {
                points.add(!point);
                continue;
            }
            points.add(point);
        }
        this.points = points;
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
