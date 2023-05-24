package nextstep.ladder.domain.nextstep;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.engine.Ladder;
import nextstep.ladder.domain.engine.LadderCreator;
import nextstep.ladder.domain.engine.Line;
import nextstep.ladder.domain.engine.LineCreator;
import nextstep.ladder.domain.strategy.BridgeStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NextStepLadderCreator implements LadderCreator {

    private final LineCreator lineCreator;

    public NextStepLadderCreator(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    @Override
    public Ladder create(Participants participants, Height height, BridgeStrategy strategy) {

        lineCreator.create(participants.number(), strategy);
        List<Line> ladder = Stream.generate(() -> lineCreator.create(participants.number(), strategy))
                .limit(height.getHeight())
                .collect(Collectors.toList());
        return new NextStepLadder(ladder);
    }
}
 