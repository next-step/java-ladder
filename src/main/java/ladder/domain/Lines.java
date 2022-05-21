package ladder.domain;

import ladder.generator.BridgeGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private static final int START_INDEX = 0;

    private final List<Line> lines;

    public Lines(Height height, Players players, BridgeGenerator bridgeGenerator) {
        this(of(height, players, bridgeGenerator));
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    private static List<Line> of(Height height, Players players, BridgeGenerator bridgeGenerator) {
        return IntStream
                .range(START_INDEX, height.getHeight())
                .mapToObj(index -> new Line(bridgeGenerator.generate(players.getPlayers().size())))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
