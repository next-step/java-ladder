package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Bridge> steps;

    public Ladder() {
        steps = new ArrayList<>();
    }

    public List<Bridge> createSteps(int maxLadderHeight, int participantCount, ConnectionStrategy strategy) {
        IntStream.range(0, maxLadderHeight)
                .forEach(index -> {
                    steps.add(new Bridge());
                    steps.get(index).connectSteps(participantCount, strategy);
                });

        return steps;
    }

}
