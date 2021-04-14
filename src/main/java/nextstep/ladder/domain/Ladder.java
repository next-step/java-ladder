package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.strategy.BridgeBuilder;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();
    private BridgeBuilder bridgeBuilder;

    public Ladder(int height, int countOfPerson) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다: " + height);
        }
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
        this.bridgeBuilder = new BridgeBuilder(height, countOfPerson);
    }

    public Ladder(int height, int countOfPerson, BridgeBuilder bridgeBuilder) {
        this(height, countOfPerson);
        this.bridgeBuilder = bridgeBuilder;
    }

    public int getHeight() {
        return lines.size();
    }

    public List<String> build() {
        return bridgeBuilder.build(lines);
    }
}
