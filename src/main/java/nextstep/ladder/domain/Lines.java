package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private static final int FIRST_LINE_INDEX = 0;

    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(int size, int height) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Direction> points = initPoints(i, height);
            lines.add(new Line(points));
        }
    }

    private List<Direction> initPoints(int index, int height) {
        List<Direction> points = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Direction previousDirection = previousDirection(index - 1, i);
            boolean isLastIndex = i == height - 1; // TODO : Point를 부활시켜 그 안으로 넣을 예정입니다.
            Direction direction = Direction.getRandomDirection(previousDirection, isLastIndex);
            points.add(direction);
        }

        return points;
    }

    // TODO return null 대신 다른 방법이 있는지 고려해볼 예정입니다.
    private Direction previousDirection(int index, int height) {
        if (index < FIRST_LINE_INDEX) {
            return null;
        }

        return getDirection(index, height);
    }

    public int size() {
        return lines.size();
    }

    public Direction getDirection(int index, int height) {
        return lines.get(index).getDirectionByHeight(height);
    }
}
