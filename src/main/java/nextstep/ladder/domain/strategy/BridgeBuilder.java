package nextstep.ladder.domain.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Line;

public class BridgeBuilder {
    private final List<String> buildMap;

    public BridgeBuilder(List<String> buildMap) {
        this.buildMap = buildMap;
    }

    public BridgeBuilder(int height, int countOfPerson) {
        this.buildMap = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            buildMap.add(MapBuilder.createRandomBridge(countOfPerson));
        }
    }

    public List<String> build(List<Line> ladderLines) {
        // TODO buildMap에 따라 사다리 긋기
        for (int i = 0; i < ladderLines.size(); i++) {
            ladderLines.get(i).createBridge(parseListOfInteger(buildMap.get(i)));
        }
        return buildMap;
    }

    private List<Integer> parseListOfInteger(String mapLine) {
        return Arrays.stream(mapLine.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
