package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    public static final int MAX_HEIGHT = 1;
    private final List<Line> lines;
    private final List<String> result;

    public Ladder(int rows, int columns) {
        this(makeLines(rows, columns));
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

    public String getResult(int index) {
        int idx = index;
        for (Line line: lines) {
            idx = line.move(idx);
        }
        return result.get(idx);
    }

    public List<Line> lines() {
        return lines;
    }
}
