package nextstep.ladder.domain.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Integer> getBuildPoints(int index) {
        return Arrays.stream(buildMap.get(index).split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
