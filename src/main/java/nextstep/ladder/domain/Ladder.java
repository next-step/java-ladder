package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BridgeStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final Participants participant;


    public static Ladder of(Participants participants) {
        return new Ladder(participants);
    }

    private Ladder(Participants participants) {
        this.participant = participants;
    }


    public List<Line> create(Height height, BridgeStrategy strategy) {
        return Stream.generate(() -> new Line(participant.number(), strategy))
                .limit(height.getHeight())
                .collect(Collectors.toList());
    }
}
