package ladder.domain;

import ladder.domain.enums.Direction;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Direction> points = new ArrayList<>();
    public static final int MIN_WIDTH = 2;

    public Line(List<Direction> points) {
        validateWidth(points.size());

        this.points = points;
    }

    public static Line createLineWithWidth(int width) {
        validateWidth(width);

        List<Direction> points = new ArrayList<>();

        Direction direction = Direction.NONE; // 초기값
        for (int i = 0; i < width; i++) {
            direction = Direction.getConnected(direction, i == width - 1);
            points.add(direction);
        }

        return new Line(points);
    }

    private static void validateWidth(int points) {
        if (points < MIN_WIDTH) {
            throw new IllegalArgumentException("사다리 폭은 " + MIN_WIDTH + " 이상이어야 합니다.");
        }
    }

    public List<Direction> getPoints() {
        return points;
    }

    public int getNextPosition(int currentPosition) {
        return points.get(currentPosition).getNext(currentPosition);
    }

}
