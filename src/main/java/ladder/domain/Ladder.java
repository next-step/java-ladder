package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Bridge> steps;

    public Ladder() {
        steps = new ArrayList<>();
    }

    public List<Bridge> createSteps(int maxLadderHeight, int participantCount, ConnectionStrategy strategy) {
        return IntStream.range(0, maxLadderHeight)
                .mapToObj(index -> {
                    Bridge bridge = new Bridge();
                    bridge.connectSteps(participantCount, strategy);
                    steps.add(bridge);
                    return bridge;
                })
                .collect(Collectors.toList());
    }

}
