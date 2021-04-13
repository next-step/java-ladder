package nextstep.ladder.domain;

import nextstep.ladder.strategy.RandomConnectStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private final Height height;
    private final CountOfPlayer countOfPlayer;

    public Ladder(Height height, CountOfPlayer countOfPlayer) {
        this.height = height;
        this.countOfPlayer = countOfPlayer;
        this.lines = create();
    }

    private List<Line> create() {
        return IntStream.range(0, height.value())
                .mapToObj((i) -> new Line(countOfPlayer, new RandomConnectStrategy()))
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public List<List<Boolean>> linesConnection() {
        return lines.stream()
                .map(Line::pointsConnection)
                .collect(Collectors.toList());
    }
}
