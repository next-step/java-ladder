package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private static final int PREVIOUS_CORRECTION = 1;
    private static final int LADDER_BOUND_START_POSITION = 0;
    private static final int LOOP_INDEX = 1;

    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
        validateLine();
    }

    private void validateLine() {
        for (int i = LOOP_INDEX; i < this.points.size(); i++) {
            validateDoubleTrueLine(i);
        }
    }

    private void validateDoubleTrueLine(int i) {
        if (points.get(i - PREVIOUS_CORRECTION).getType() && points.get(i).getType()) {
            points.set(i, new Point(Boolean.FALSE));
        }
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    private boolean isPoint(int index) {
        return points.get(index).getType();
    }

    public List<Boolean> types() {
        return points.stream()
                .map(Point::getType)
                .collect(Collectors.toList());
    }

    public int move(int index) {
        if (index == LADDER_BOUND_START_POSITION) {
            return moveToFirstIndex(this, index);
        }
        return MovingOperator.getPosition(new Moving(this.isPoint(index - PREVIOUS_CORRECTION), this.isPoint(index)));
    }

    private int moveToFirstIndex(Line line, int index) {
        if (line.isPoint(index)) {
            return MovingOperator.getPosition(Moving.right());
        }
        return MovingOperator.getPosition(Moving.stay());
    }
}
