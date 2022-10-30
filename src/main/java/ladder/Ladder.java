package ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Row> rows;

    private Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public static Ladder of(int people, int height) {
        RowGenerator rowGenerator = new RowGenerator();

        List<Row> rows = IntStream.range(0, height)
            .mapToObj(i -> rowGenerator.create(people))
            .collect(Collectors.toList());

        return new Ladder(rows);
    }

    public List<Row> getLadderLines() {
        return rows;
    }

    public Map play(int people) {
        // index, position
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < people; i++) {
            result.put(i, i);
        }

        for (int i = 0; i < people; i++) {
            for (int j = 0; j < rows.size(); j++) {
                if (rows.get(j).getPoints().get(result.get(i)).equals(true)) {
                    result.put(i, result.get(i)+1); // 오른쪽으로 이동
                } else {
                    // 왼쪽으로 이동
                    if (result.get(i) > 0 && rows.get(j).getPoints().get(result.get(i)-1).equals(true)) {
                        result.put(i, result.get(i)-1);
                    }
                }
            }
        }

        return result;
    }
}
