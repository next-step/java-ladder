package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BridgeStrategy;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder implements Iterable<Line>{

    private final List<Line> ladder;

    public static Ladder of(Participants participants, Height height, BridgeStrategy strategy) {
        return new Ladder(participants, height, strategy);
    }

    private Ladder(Participants participants, Height height, BridgeStrategy strategy) {
        this.ladder = create(participants,height, strategy);
    }

    public List<Line> create(Participants participants, Height height, BridgeStrategy strategy) {
        return Stream.generate(() -> new Line(participants.number(), strategy))
                .limit(height.getHeight())
                .collect(Collectors.toList());
    }

    int size() {
        return ladder.size();
    }

    @Override
    public Iterator<Line> iterator() {
        return ladder.iterator();
    }
}
