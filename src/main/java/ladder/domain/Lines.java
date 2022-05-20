package ladder.domain;

import ladder.generator.BridgeGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(Height height, Players players, BridgeGenerator bridgeGenerator) {
        this(of(height, players, bridgeGenerator));
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    private static List<Line> of(Height height, Players players, BridgeGenerator bridgeGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(bridgeGenerator.generate(players.getPlayers().size())));
        }
        return lines;
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
