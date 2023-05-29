package ladder.domain;

import ladder.domain.enums.Direction;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Direction> points = new ArrayList<>();
    public static final int MIN_WIDTH = 2;

    public Line(int width) {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException("사다리 폭은 " + MIN_WIDTH + " 이상이어야 합니다.");
        }
        Direction direction = Direction.NONE; // 초기값
        for (int i = 0; i < width; i++) {
            direction = Direction.getConnectDirection(direction, i == width - 1);
            points.add(direction);
        }
    }

    public List<Direction> getPoints() {
        return points;
    }

}
