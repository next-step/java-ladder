package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderFloor> ladder;

    private Ladder(List<LadderFloor> ladder) {
        this.ladder = ladder;
    }

    public static Ladder create(final LadderSize ladderSize, final LadderLineGenerator ladderLineGenerator) {
        return Stream.generate(() -> new LadderFloor(ladderSize, ladderLineGenerator))
                .limit(ladderSize.getLadderHeight())
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder::new));
    }

    public List<LadderFloor> getFloors() {
        return ladder;
    }
}
