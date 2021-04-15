package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.strategy.BridgeBuilder;

public class Ladder {
    static final int LADDER_MIN_HEIGHT = 5;

    private final List<Line> lines = new ArrayList<>();
    private BridgeBuilder bridgeBuilder;

    public Ladder(int height, int countOfPerson) {
        if (height < LADDER_MIN_HEIGHT) {
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
        List<String> buildMap = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            lines.get(i).createBridge(bridgeBuilder.getBuildPoints(i));
            buildMap.add(buildPointsToString(bridgeBuilder.getBuildPoints(i)));
        }
        return buildMap;
    }

    private String buildPointsToString(List<Integer> buildPoints) {
        return buildPoints.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
