package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderFloor> ladder;

    Ladder(List<LadderFloor> ladder) {
        this.ladder = ladder;
    }

    public static Ladder create(final int countOfParticipants, final int ladderHeight, final LadderLineGenerator ladderLineGenerator) {
        return Stream.generate(() -> new LadderFloor(countOfParticipants, ladderLineGenerator))
                .limit(ladderHeight)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder::new));
    }

    public List<LadderFloor> getFloors() {
        return ladder;
    }
}
