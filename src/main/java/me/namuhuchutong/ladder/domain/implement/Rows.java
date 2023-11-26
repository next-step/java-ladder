package me.namuhuchutong.ladder.domain.implement;

import me.namuhuchutong.ladder.domain.engine.ScaffoldFactory;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Rows {

    private static final String NEW_LINE = "\n";
    private static final int MINIMUM_HEIGHT = 1;
    private static final int MAXIMUM_HEIGHT = 10;
    private static final String BLANK = "";

    private final List<Row> values;

    public static Rows createLadder(int height,
                                    int participants,
                                    ScaffoldFactory factory) {
        List<Row> collect = Stream.generate(() -> Row.from(participants, factory))
                                  .limit(height)
                                  .collect(toUnmodifiableList());
        return new Rows(collect);
    }

    public Rows(List<Row> values) {
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
        for (Row row : values) {
            currentPoint = row.move(currentPoint);
        }
        return currentPoint;
    }

    @Override
    public String toString() {
        return this.values.stream()
                          .map(Row::toString)
                          .map(string -> string + NEW_LINE)
                          .reduce(BLANK, (previous, newOne) -> previous + newOne);
    }
}
