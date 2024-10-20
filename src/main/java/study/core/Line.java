package study.core;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validate(points);
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public void validate(List<Boolean> points) {
        if (points == null) {
            throw new IllegalArgumentException("null 값이 입력되었습니다.");
        }
        if (hasAdjacentTrue(points)) {
            throw new IllegalArgumentException("인접한 값이 모두 true일 수 없습니다.");
        }
    }

    private boolean hasAdjacentTrue(List<Boolean> points) {
        return IntStream.range(0, points.size() - 1)
                .anyMatch(i -> points.get(i) && points.get(i + 1));
    }

    public void createPoints(int playerCount) {
        Random random = new Random();
        boolean hasPreviousLine = false;
        for (int i = 0; i < playerCount - 1; i++) {
            hasPreviousLine = addPoint(random, hasPreviousLine);
        }
    }

    private boolean addPoint(Random random, boolean hasPreviousLine) {
        if (hasPreviousLine) {
            points.add(false);
            return false;
        }
        boolean hasLine = random.nextBoolean();
        points.add(hasLine);
        return hasLine;
    }

    public int move(int position) {
        if (isLeftMovable(position)) {
            return position - 1;
        }
        if (isRightMovable(position)) {
            return position + 1;
        }
        return position;
    }

    private boolean isLeftMovable(int position) {
        return position > 0 && points.get(position - 1);
    }

    private boolean isRightMovable(int position) {
        return position < points.size() && points.get(position);
    }
}
