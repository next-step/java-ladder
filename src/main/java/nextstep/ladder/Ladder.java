package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    public static final int MAX_HEIGHT = 1;
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder(int rows, int columns) {
        if (columns < MAX_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리는 높이가 %d 이상이여야 합니다", MAX_HEIGHT));
        }
        this.lines = Stream.generate(() -> new Line(rows))
                .limit(columns)
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return lines;
    }
}
