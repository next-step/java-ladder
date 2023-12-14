package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    public static final int MAX_HEIGHT = 1;
    private final List<Line> lines;
    private final List<String> result;

    public Ladder(int rows, int columns, String... result) {
        this(makeLines(rows, columns), validateResult(rows, result));
    }

    private static List<String> validateResult(int rows, String[] result) {
        if (rows != result.length) {
            throw new IllegalArgumentException(
                    String.format("결과 값과 인원수가 맞지 않으면 사다리를 구축할 수 없습니다 결과값: %d, 인원수: %d", result.length, rows)
            );
        }
        return List.of(result);
    }

    public Ladder(List<Line> lines) {
        this(lines, new ArrayList<>());

    }

    public Ladder(List<Line> lines, List<String> result) {
        this.lines = lines;
        this.result = result;
    }

    private static List<Line> makeLines(int rows, int columns) {
        if (columns < MAX_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리는 높이가 %d 이상이여야 합니다", MAX_HEIGHT));
        }
        return Stream.generate(() -> new Line(rows))
                .limit(columns)
                .collect(Collectors.toList());
    }

    public String getLadderResult(int index) {
        int idx = index;
        for (Line line: lines) {
            idx = line.move(new Position(idx, result.size()));
        }
        return result.get(idx);
    }

    public Map<Integer, String> getLadderAllResult() {
        HashMap<Integer, String> map = new HashMap();
        for (int index = 0; index < this.columnSize(); index++) {
            map.put(index, getLadderResult(index));
        }
        return map;
    }

    public List<Line> lines() {
        return lines;
    }

    public List<String> getResult() {
        return result;
    }

    private int columnSize() {
        return lines.get(0).size()+1;
    }
}
