package ladder.domain;

import ladder.domain.enums.Direction;
import ladder.engine.Line;

import java.util.ArrayList;
import java.util.List;

import static ladder.domain.JerryLineCreator.MIN_WIDTH;

public class JerryLine implements Line {
    private List<Direction> points = new ArrayList<>();
//    public static final int MIN_WIDTH = 2;

    public JerryLine(List<Direction> points) {
//        validateWidth(points.size());

        this.points = points;
    }

    public static JerryLine createLineWithWidth(int width) {
//        validateWidth(width);

        List<Direction> points = new ArrayList<>();

        Direction direction = Direction.NONE; // 초기값
        for (int i = 0; i < width; i++) {
            direction = Direction.getConnected(direction, i == width - 1);
            points.add(direction);
        }

        return new JerryLine(points);
    }

//    private static void validateWidth(int points) {
//        if (points < MIN_WIDTH) {
//            throw new IllegalArgumentException("사다리 폭은 " + MIN_WIDTH + " 이상이어야 합니다.");
//        }
//    }

    public List<Direction> getPoints() {
        return points;
    }

    public int getNextPosition(int currentPosition) {
        return points.get(currentPosition).getNext(currentPosition);
    }

}
