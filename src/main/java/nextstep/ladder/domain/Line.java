package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final String HORIZONTAL_BAR = "-----";
    private static final String EMPTY_HORIZONTAL_BAR = "     ";
    private static final String ROW_DELIMITER = "|";

    private final List<String> crosses;
    private final BarGeneratorStrategy generatorStrategy;

    public Line(PositiveNumber width, BarGeneratorStrategy generatorStrategy) {
        this.generatorStrategy = generatorStrategy;
        this.crosses = new ArrayList<>();
        makeCrosses(width);
    }

    private void makeCrosses(PositiveNumber width) {
        for (int i = 0; i < width.getValue(); i++) {
            crosses.add(getBar(i));
        }
    }

    public List<String> getCrosses() {
        return Collections.unmodifiableList(crosses);
    }

    private String getBar(int point) {
        if (point == 0) {
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

    private String getPreviousBar(int point) {
        return crosses.get(point - 1);
    }

    public String getRowAsString() {
        return String.join("|", crosses) + ROW_DELIMITER;
    }

    public boolean isRightMoveable(int currentPoint) {
        if (isOverRightLimit(currentPoint)) {
            return false;
        }
        return crosses.get(currentPoint + 1).equals(HORIZONTAL_BAR);
    }

    private boolean isOverRightLimit(int currentPoint) {
        return currentPoint + 1 >= crosses.size();
    }

    public boolean isLeftMoveable(int currentPoint) {
        if (isOverLeftLimit(currentPoint)) {
            return false;
        }
        return crosses.get(currentPoint).equals(HORIZONTAL_BAR);
    }

    private boolean isOverLeftLimit(int currentPoint) {
        return currentPoint - 1 < 0;
    }
}
