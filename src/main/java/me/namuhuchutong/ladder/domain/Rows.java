package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.factory.ScaffoldFactory;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Rows {

    private static final String NEW_LINE = "\n";
    private static final int MINIMUM_HEIGHT = 1;
    private static final int MAXIMUM_HEIGHT = 10;

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
        if (isLessThanZeroOrBiggerThanTen(size)) {
            throw new IllegalArgumentException("높이가 1보다 작거나 10보다 크다면 사다리는 생성할 수 없습니다.");
        }
    }

    private boolean isLessThanZeroOrBiggerThanTen(int size) {
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
                          .reduce("", (previous, newOne) -> previous + newOne);
    }
}
