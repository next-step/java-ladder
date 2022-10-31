package ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        LadderResult result2 = LadderResult.of(people);
        // index, position
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < people; i++) {
            result.put(i, i);
        }

        for (int i = 0; i < people; i++) {
            for (int j = 0; j < rows.size(); j++) {
                if (rows.get(j).getPoints().get(result2.getTarget(i)).equals(true)) {
                    result2.put(i, result2.getTarget(i) + 1); // 오른쪽으로 이동
                } else {
                    // 왼쪽으로 이동
                    if (result2.getTarget(i) > 0 && rows.get(j).getPoints().get(result2.getTarget(i)-1).equals(true)) {
                        result2.put(i, result2.getTarget(i)-1);
                    }
                }
            }
        }

        return result2;
    }
}
