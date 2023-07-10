package ladder.domain;

import ladder.domain.enums.Direction;
import ladder.engine.Line;
import ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class JerryLineCreator implements LineCreator {
    public static final int MIN_WIDTH = 2;

    public Line createLine(int width) {
        validateWidth(width);

        List<Direction> points = new ArrayList<>();

        Direction direction = Direction.NONE; // 초기값
        for (int i = 0; i < width; i++) {
            direction = Direction.getConnected(direction, i == width - 1);
            points.add(direction);
        }

        return new JerryLine(points);
    }

    private void validateWidth(int points) {
        if (points < MIN_WIDTH) {
            throw new IllegalArgumentException("사다리 폭은 " + MIN_WIDTH + " 이상이어야 합니다.");
        }
    }
}
