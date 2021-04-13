package nextstep.ladder.domain;

import nextstep.ladder.strategy.RandomConnectStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(int countOfPlayer, int height) {
        this(new CountOfPlayer(countOfPlayer), new Height(height));
    }

    public Lines(CountOfPlayer countOfPlayer, Height height) {
        this(createWith(countOfPlayer, height));
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static List<Line> createWith(CountOfPlayer countOfPlayer, Height height) {
        return IntStream.range(0, height.value())
                .mapToObj((i) -> new Points(countOfPlayer, new RandomConnectStrategy()))
                .map(Line::new)
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public List<List<Boolean>> linesConnection() {
        return lines.stream()
                .map(Line::points)
                .map(Points::pointsConnection)
                .collect(Collectors.toList());
    }

    public int size() {
        return lines.size();
    }
}
