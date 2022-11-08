package ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {

    private LadderFactory() {
    }

    public static Ladder create(final Participants participants, final LadderHeight height) {
        Lines lines = new Lines(IntStream.range(0, height.getValue())
                                         .mapToObj(index -> LineFactory.create(participants.size()))
                                         .collect(Collectors.toList()));
        return new Ladder(participants, lines);
    }
}
