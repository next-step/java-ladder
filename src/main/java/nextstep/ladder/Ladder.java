package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private List<Line> points;

    public Ladder(List<Line> points) {
        this.points = points;
    }

    public Ladder(int rows, int columns) {
        this.points = Stream.generate(() -> new Line(rows)).limit(columns).collect(Collectors.toList());
    }
}
