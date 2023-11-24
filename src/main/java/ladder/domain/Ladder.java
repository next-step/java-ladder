package ladder.domain;

import ladder.domain.strategy.CoordinateGeneration;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderLine> ladder;

    public Ladder(People people, Height heightCount, CoordinateGeneration coordinateGeneration) {
        this.ladder = makeLadder(people, heightCount, coordinateGeneration);
    }

    private static List<LadderLine> makeLadder(People people, Height heightCount, CoordinateGeneration coordinateGeneration) {
        return Stream
                .generate(() -> new LadderLine(people, coordinateGeneration))
                .limit(heightCount.find())
                .collect(Collectors.toList());

    }

    public List<LadderLine> draw() {
        return Collections.unmodifiableList(ladder);
    }
}
