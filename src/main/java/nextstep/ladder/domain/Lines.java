package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines fromHeight(int height, ConnectionCreationStrategy connectionCreationStrategy) {
        return new Lines(IntStream.range(0, height)
                .mapToObj(idx -> new Line(idx, connectionCreationStrategy))
                .collect(Collectors.toList()));
    }
}
