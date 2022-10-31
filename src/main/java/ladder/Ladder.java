package ladder;

import java.util.List;

public class Ladder {

    private final List<Row> rows;

    private Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public static Ladder of(List<Row> rows) {
        return new Ladder(rows);
    }

    public List<Row> getLadderLines() {
        return rows;
    }

    public LadderResult play(int people) {
        LadderResult result = LadderResult.of(people);
        // index, position

        for (int i = 0; i < people; i++) {
            for (Row row : rows) {
                if (row.move(result.getTarget(i))) {
                    // 오른쪽으로 이동
                    result.put(i, result.getTarget(i) + 1);
                } else {
                    // 왼쪽으로 이동
                    if (result.getTarget(i) > 0 && row.move(result.getTarget(i) - 1)) {
                        result.put(i, result.getTarget(i)-1);
                    }
                }
            }
        }
        return result;
    }
}
