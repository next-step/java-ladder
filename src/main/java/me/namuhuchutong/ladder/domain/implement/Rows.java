package me.namuhuchutong.ladder.domain.implement;

import me.namuhuchutong.ladder.domain.engine.Line;

import java.util.List;

public class Rows {

    private static final String NEW_LINE = "\n";
    private static final int MINIMUM_HEIGHT = 1;
    private static final int MAXIMUM_HEIGHT = 10;
    private static final String BLANK = "";

    private final List<Line> values;

    public Rows(List<Line> values) {
        validateLadderHeight(values.size());
        this.values = values;
    }

    private void validateLadderHeight(int size) {
        if (isOutOfHeightCondition(size)) {
            throw new IllegalArgumentException("사다리 높이 조건을 벗어났습니다. - " + size);
        }
    }

    private boolean isOutOfHeightCondition(int size) {
        return size < MINIMUM_HEIGHT || MAXIMUM_HEIGHT < size;
    }

    public int move(int startPoint) {
        int currentPoint = startPoint;
        for (Line line: values) {
            currentPoint = line.move(currentPoint);
        }
        return currentPoint;
    }

    @Override
    public String toString() {
        return this.values.stream()
                          .map(Line::toString)
                          .map(string -> string + NEW_LINE)
                          .reduce(BLANK, (previous, newOne) -> previous + newOne);
    }
}
