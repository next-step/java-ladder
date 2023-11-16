package me.namuhuchutong.ladder;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Rows {

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
        validateLadderHeight(values);
        this.values = values;
    }

    private void validateLadderHeight(List<Row> values) {
        if (isLessThanZeroAndBiggerThanTen(values)) {
            throw new IllegalArgumentException("높이가 1보다 작거나 10보다 크다면 사다리는 생성할 수 없습니다.");
        }
    }

    private boolean isLessThanZeroAndBiggerThanTen(List<Row> values) {
        return values.size() < 1 || 10 < values.size();
    }
}
