package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder(int rows, int columns) {
        if (columns > 0 ) {
            throw new IllegalArgumentException("사다리는 높이가 1 이상이여야합니다.");
        }
        this.lines = Stream.generate(() -> new Line(rows))
                .limit(columns)
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return lines;
    }
}
