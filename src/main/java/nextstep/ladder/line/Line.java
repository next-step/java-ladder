package nextstep.ladder.line;

import nextstep.ladder.Direction;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.ui.ResultView.VERTICAL_LINE;

public class Line {
    private List<Direction> directions = new ArrayList<>();

    public Line(int size) {
        validate(size);
        generateDirections(size);
    }

    public Direction getDirection(int index) {
        return directions.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VERTICAL_LINE);
        for (int i = 0; i < directions.size() - 1; i++) {
            sb.append(directions.get(i).toString());
            sb.append(VERTICAL_LINE);
        }
        return sb.toString();
    }

    private void generateDirections(int size) {
        Direction before = null;
        for (int i = 0; i < size; i++) {
            before = Direction.of(before, isLast(i, size));
            directions.add(before);
        }
    }

    private boolean isLast(int index, int size) {
        return index == size - 1;
    }

    private void validate(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("사다리 길이는 0보다 작을 수 없습니다.");
        }
    }
}
