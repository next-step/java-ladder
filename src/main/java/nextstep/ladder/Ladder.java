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
        if (columns > 0 ) {
            throw new IllegalArgumentException("사다리는 높이가 1 이상이여야합니다.");
        }
        this.points = Stream.generate(() -> new Line(rows))
                .limit(columns)
                .collect(Collectors.toList());
    }



}
