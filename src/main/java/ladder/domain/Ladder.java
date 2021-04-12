package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Ladder {

    private final List<Line> ladder;

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static final Ladder from(Participants participants, int height) {
        return new Ladder(IntStream.range(0, height)
                .mapToObj(i-> Line.of(participants.countOfPerson()))
                .collect(Collectors.toList())
        );
    }
}
