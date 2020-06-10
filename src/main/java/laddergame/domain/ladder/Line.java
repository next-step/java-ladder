package laddergame.domain.ladder;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Bridge> bridges;

    public Line(int numberOfPlayer, BridgeGenerator bridgeGenerator) {
        this.bridges = bridgeGenerator.generate(numberOfPlayer);
    }

    public List<Bridge> getLine() {
        return Collections.unmodifiableList(bridges);
    }

}
