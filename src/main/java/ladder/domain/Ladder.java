package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final List<Floor> ladder;

    Ladder(List<Floor> ladder) {
        this.ladder = ladder;
    }

    public static Ladder create(int countOfParticipants, int ladderHeight) {
        return Stream.generate(() -> new Floor(countOfParticipants))
                .limit(ladderHeight)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder::new));
    }

    public List<Floor> getFloors() {
        return ladder;
    }
}
