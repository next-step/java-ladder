package nextstep.ladder.engine;

import java.util.List;

public interface LadderBuilder {
    LadderRails buildRails(List<String> players, List<String> results);
    LadderFrame buildFrame(LadderRails rails, int height);
    Ladder buildLadder(LadderFrame frame, LadderPointGenerateStrategy strategy);
}
