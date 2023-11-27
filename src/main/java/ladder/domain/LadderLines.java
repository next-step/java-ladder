package ladder.domain;

import ladder.domain.strategy.CoordinateGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderLines {
    private final List<LadderLine> ladder;

    public LadderLines(List<LadderLine> list) {
        this.ladder = list;
    }

    public static LadderLines of(People people, Height heightCount, CoordinateGenerator coordinateGeneration) {
        return Stream
                .generate(() -> LadderLine.of(people, coordinateGeneration))
                .limit(heightCount.find())
                .collect(collectingAndThen(toList(), LadderLines::new));

    }

    public List<LadderLine> draw() {
        return Collections.unmodifiableList(ladder);
    }

    public int move(int start) {
        for (LadderLine ladderLine : ladder) {
            start = ladderLine.move(start);
        }

        return start;
    }
}
