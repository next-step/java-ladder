package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final double THRESHOLD = 0.5;
    private static final String HORIZONTAL = "-----";
    private static final String VERTICAL = "|";
    private static final String EMPTY = "     ";

    private List<Boolean> points = new ArrayList<>();

    public Line(int size) {
        validate(size);
        generatePoints(size);
    }

    private void generatePoints(int size) {
        boolean before = false;
        for (int i = 0; i < size; i++) {
            before = generatePoint(before);
            points.add(before);
        }
    }

    public boolean generatePoint(boolean before) {
        if (before) {
            return false;
        }

        return generatePoint(Math.random());
    }

    public boolean generatePoint(double number) {
        return number < THRESHOLD;
    }

    private void validate(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("사다리 길이는 0보다 작을 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VERTICAL);
        for (Boolean point : points) {
            sb.append(toString(point));
            sb.append(VERTICAL);
        }
        return sb.toString();
    }

    private String toString(Boolean point) {
        if (point) {
            return HORIZONTAL;
        }

        return EMPTY;
    }
}
