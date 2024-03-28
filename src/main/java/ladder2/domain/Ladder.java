package ladder2.domain;

import java.util.List;

public class Ladder {

    private final List<LadderRow> rows;

    public Ladder(List<LadderRow> rows) {
        validate(rows);
        this.rows = rows;
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
}
