package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.strategy.BridgeBuilder;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();
    private final BridgeBuilder bridgeBuilder;

    public Ladder(int height, int countOfPerson, BridgeBuilder bridgeBuilder) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
        this.bridgeBuilder = bridgeBuilder;
    }

    public int getHeight() {
        return lines.size();
    }

    public List<String> build() {
        return bridgeBuilder.build(lines);
    }
}
