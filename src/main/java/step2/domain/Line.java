package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(int size, Condition condition) {
        return IntStream.range(0, size)
                .mapToObj(index ->
                        condition.getCondition())
                .collect(Collectors.collectingAndThen(Collectors.toList(), Line::new));
    }

    public int getSize() {
        return points.size();
    }

    public boolean isMoveable(int position) {
        if (validate(position)) {
            return false;
        }

        return points.get(position);
    }

    private boolean validate(int position) {
        if (position == points.size()) {
            return true;
        }

        if (position < 0) {
            return true;
        }

        return false;
    }

    public Position movePosition(Position position) {

        if (getForwardPoint(position.getValue())) {
            return position.move(1);
        }

        if (getBackwardPoint(position.getValue())) {
            return position.move(-1);
        }

        return position.move(0);
    }

    private boolean getForwardPoint(int position) {
        if (validate(position)) {
            return false;
        }

        return points.get(position);
    }

    private boolean getBackwardPoint(int position) {
        if (validate(position - 1)) {
            return false;
        }

        return points.get(position - 1);
    }
}
