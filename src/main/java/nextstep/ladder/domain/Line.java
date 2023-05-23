package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    private Line(int countOfPerson) {
        points = drawLine(countOfPerson);
    }

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson) {
        return new Line(countOfPerson);
    }

    public static Line of(List<Boolean> points) {
        validLine(points);
        return new Line(points);
    }

    private static boolean validLine(List<Boolean> points) {
        for (int i = 1; i < points.size(); i++) {
            validPoint(points.get(i - 1), points.get(i));
        }
        return true;
    }

    private static void validPoint(Boolean left, Boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("가로 라인은 겹칠 수 없습니다.");
        }
    }


    protected List<Boolean> drawLine(int countOfPerson) {
        if (countOfPerson == 0) {
            return new ArrayList<>();
        }

        int ladderWeight = countOfPerson - 1;
        final List<Boolean> newLine = new ArrayList<>(ladderWeight);
        newLine.add(createFirstBoolean());
        for (int i = 1; i < ladderWeight; i++) {
            newLine.add(generateBooleanWithPreviousValue(newLine.get(i - 1)));
        }
        return newLine;
    }

    private boolean createFirstBoolean() {
        return RandomBooleanGenerator.getRandomBoolean();
    }

    private boolean generateBooleanWithPreviousValue(boolean previousValue) {
        if (previousValue == Boolean.TRUE) {
            return Boolean.FALSE;
        }
        return RandomBooleanGenerator.getRandomBoolean();
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> toList() {
        return Collections.unmodifiableList(points);
    }
}
