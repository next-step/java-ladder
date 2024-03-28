package ladder2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderRow> rows;

    public Ladder(List<LadderRow> rows) {
        validate(rows);
        this.rows = Collections.unmodifiableList(rows);
    }

    private void validate(List<LadderRow> rows) {
        validateNotEmpty(rows);
        validateSameColumnSize(rows);
    }

    private static void validateNotEmpty(List<LadderRow> rows) {
        if (rows.isEmpty()) {
            throw new IllegalArgumentException("LadderRow가 1개 이상 있어야 합니다");
        }
    }

    private static void validateSameColumnSize(List<LadderRow> rows) {
        boolean sameColumnSize = rows.stream().map(LadderRow::columnSize).distinct().count() == 1;
        if (!sameColumnSize) {
            throw new IllegalArgumentException("모든 LadderRow의 열 개수가 일치해야 합니다");
        }
    }

    public LadderResult result() {
        Map<Integer, Integer> resultIndices = resultIndices();
        return new LadderResult(resultIndices);
    }

    private Map<Integer, Integer> resultIndices() {
        return IntStream.range(0, rows.get(0).columnSize())
            .boxed()
            .collect(
                Collectors.toMap(
                    i -> i,
                    this::resultIndexOf
                )
            );
    }

    private int resultIndexOf(int index) {
        for (LadderRow row : rows) {
            index = row.nextColumnIndex(index);
        }
        return index;
    }

    public List<LadderRow> rows() {
        return rows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(rows, ladder.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows);
    }

    @Override
    public String toString() {
        return "Ladder{" +
            "rows=" + rows +
            '}';
    }
}
