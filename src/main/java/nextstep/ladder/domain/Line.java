package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    private Line(int width) {
        points = drawLine(width);
    }

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson) {
        validLineLength(countOfPerson);
        return new Line(countOfPerson);
    }

    public static Line of(List<Boolean> points) {
        validLineLength(points.size());
        validLine(points);
        return new Line(points);
    }

    private static void validLineLength(int countOfPerson) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException("게임 진행을 위한 최소 인원수는 2명입니다.");
        }
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

        int width = countOfPerson;
        final List<Boolean> newLine = new ArrayList<>(width);
        newLine.add(createFirstBoolean());
        for (int i = 1; i < width; i++) {
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

    public int movePin(int index) {
        if (canMoveLeft(index)) {
            return index - 1;
        }
        if (catMoveRight(index)) {
            return index + 1;
        }
        return index;
    }

    private boolean canMoveLeft(int index) {
        int left = index - 1;
        if (left < 0) {
            return false;
        }
        return points.get(left);
    }

    private boolean catMoveRight(int index) {
        int right = index + 1;
        if (right >= points.size()) {
            return false;
        }
        return points.get(index);
    }
}
