package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderRow {
    private static final String HORIZONTAL_BAR = "-----";
    private static final String EMPTY_HORIZONTAL_BAR = "     ";

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

    private String getBar(int index) {
        if (row.isEmpty()) {
            return EMPTY_HORIZONTAL_BAR;
        }
        if (row.get(index - 1).equals(EMPTY_HORIZONTAL_BAR)) {
            return generateLine();
        }
        return EMPTY_HORIZONTAL_BAR;
    }

    private String generateLine() {
        return generatorStrategy.generable() ? HORIZONTAL_BAR : EMPTY_HORIZONTAL_BAR;
    }

    public List<String> getRow() {
        return Collections.unmodifiableList(row);
    }
}
