package nextstep.ladder.domain;

import java.util.List;

import nextstep.ladder.engine.Ladder;
import nextstep.ladder.engine.LadderBuilder;
import nextstep.ladder.engine.LadderFrame;
import nextstep.ladder.engine.LadderRails;
import nextstep.ladder.engine.LadderPointGenerateStrategy;

public class Step4LadderBuilder implements LadderBuilder {
    @Override
    public LadderRails buildRails(List<String> players, List<String> results) {
        return Step4LadderRails.of(players, results);
    }

    @Override
    public LadderFrame buildFrame(LadderRails rails, int height) {
        return Step4LadderFrame.of(rails, height);
    }

    @Override
    public Ladder buildLadder(LadderFrame frame, LadderPointGenerateStrategy strategy) {
        return Step4Ladder.of(frame, strategy);
    }
}
