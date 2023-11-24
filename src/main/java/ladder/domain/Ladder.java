package ladder.domain;

import ladder.domain.strategy.CoordinateGeneration;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Ladder {
    private final List<LadderLine> ladder;

    public Ladder(List<LadderLine> list) {
        this.ladder = list;
    }

    public static Ladder of(People people, Height heightCount, CoordinateGeneration coordinateGeneration) {
        return Stream
                .generate(() -> LadderLine.of(people, coordinateGeneration))
                .limit(heightCount.find())
                .collect(collectingAndThen(toList(), Ladder::new));

    }

    public List<LadderLine> draw() {
        return Collections.unmodifiableList(ladder);
    }
}
