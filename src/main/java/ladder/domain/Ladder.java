package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> ladders;

    private Ladder(List<Line> ladders) {
        this.ladders = ladders;
    }

    public static Ladder of(int userCount, int height, PointStrategy pointStrategy) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(line -> new Line(userCount, pointStrategy))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public int size() {
        return ladders.size();
    }

    public Line getLine(int index) {
        return ladders.get(index);
    }
}
