package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final String HORIZONTAL_BAR = "-----";
    private static final String EMPTY_HORIZONTAL_BAR = "     ";
    private static final String ROW_DELIMITER = "|";

    private final List<String> row;
    private final BarGeneratorStrategy generatorStrategy;

    public Line(PositiveNumber width, BarGeneratorStrategy generatorStrategy) {
        this.row = new ArrayList<>();
        this.generatorStrategy = generatorStrategy;
        makeRow(width);
    }

    private void makeRow(PositiveNumber width) {
        for (int i = 0; i < width.getValue(); i++) {
            row.add(getBar(new Point(i)));
        }
    }

    public List<String> getRow() {
        return Collections.unmodifiableList(row);
    }

    private String getBar(Point point) {
        if (row.isEmpty()) {
            return EMPTY_HORIZONTAL_BAR;
        }
        if (getPreviousBar(point).equals(EMPTY_HORIZONTAL_BAR)) {
            return generateLine();
        }
        return EMPTY_HORIZONTAL_BAR;
    }

    private String generateLine() {
        if (generatorStrategy.generable()) {
            return HORIZONTAL_BAR;
        }
        return EMPTY_HORIZONTAL_BAR;
    }

    private String getPreviousBar(Point point) {
        return row.get(point.getValue() - 1);
    }

    public String getRowAsString() {
        return String.join("|", row) + ROW_DELIMITER;
    }

    public boolean isRightMoveable(Point currentPoint) {
        if (isOverRightLimit(currentPoint)) {
            return false;
        }
        return row.get(currentPoint.getValue() + 1).equals(HORIZONTAL_BAR);
    }

    private boolean isOverRightLimit(Point currentPoint) {
        return currentPoint.getValue() + 1 >= row.size();
    }

    public boolean isLeftMoveable(Point currentPoint) {
        if (isOverLeftLimit(currentPoint)) {
            return false;
        }
        return row.get(currentPoint.getValue()).equals(HORIZONTAL_BAR);
    }

    private boolean isOverLeftLimit(Point currentPoint) {
        return currentPoint.getValue() - 1 < 0;
    }
}
