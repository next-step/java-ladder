package ladder.domain;

import java.util.Arrays;

public class Ladder {
    private final LadderRow[] rows;

    public Ladder(int height, int personSize) {
        if (height < 0 || personSize < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }

        rows = Arrays.stream(new LadderRow[height])
                .map(row -> new LadderRow(personSize - 1))
                .toArray(LadderRow[]::new);
    }

    public Ladder(LadderRow[] ladderRows) {
        rows = ladderRows;
    }

    @Override
    public String toString() {
        return Arrays.stream(rows)
                .map(row -> row.toString())
                .reduce("", (left, right) -> left + right + "\n");
    }
}
