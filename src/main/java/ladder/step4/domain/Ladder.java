package ladder.step4.domain;

import ladder.step4.domain.strategy.DirectionStrategy;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Ladder {
    private final List<LadderLine> ladder;

    private Ladder(List<LadderLine> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(Participants participants, LadderHeight height, DirectionStrategy strategy) {
        int width = participants.size();
        return IntStream.range(0, height.getValue())
                        .mapToObj(h -> LadderLine.of(width, strategy))
                        .collect(collectingAndThen(toList(), Ladder::new));
    }

    public Stream<LadderLine> stream() {
        return ladder.stream();
    }
}
