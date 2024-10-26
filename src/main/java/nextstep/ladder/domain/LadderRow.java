package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderRow {
    private static final String HORIZONTAL_BAR = "-----";
    private static final String EMPTY_HORIZONTAL_BAR = "     ";
    private static final String ROW_DELIMITER = "|";

    private final List<String> row;
    private final BarGeneratorStrategy generatorStrategy;

    public LadderRow(PositiveNumber width, BarGeneratorStrategy generatorStrategy) {
        this.row = new ArrayList<>();
        this.generatorStrategy = generatorStrategy;
        makeRow(width);
    }

    private void makeRow(PositiveNumber width) {
        for (int i = 0; i < width.getValue(); i++) {
            row.add(getBar(i));
        }
    }

    public List<String> getRow() {
        return Collections.unmodifiableList(row);
    }

    private String getBar(int index) {
        if (row.isEmpty()) {
            return EMPTY_HORIZONTAL_BAR;
        }
        if (getPreviousBar(index).equals(EMPTY_HORIZONTAL_BAR)) {
            return generateLine();
        }
        return EMPTY_HORIZONTAL_BAR;
    }

    private String generateLine() {
        return generatorStrategy.generable()
                ? HORIZONTAL_BAR
                : EMPTY_HORIZONTAL_BAR;
    }

    private String getPreviousBar(int index) {
        return row.get(index - 1);
    }

    public String getRowAsString() {
        return String.join("|", row) + ROW_DELIMITER;
    }

    public boolean isRightMoveable(int currentIndex) {
        if (currentIndex + 1 >= row.size()) {
            return false;
        }
        return row.get(currentIndex + 1).equals(HORIZONTAL_BAR);
    }

    public boolean isLeftMoveable(int currentIndex) {
        if (currentIndex - 1 < 0) {
            return false;
        }
        return row.get(currentIndex).equals(HORIZONTAL_BAR);
    }
}
