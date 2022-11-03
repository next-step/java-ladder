package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderInOut;
import nextstep.ladder.domain.LadderLines;
import nextstep.ladder.domain.RandomLineStrategy;
import nextstep.ladder.domain.Users;

public class LadderFactory {

    public Ladder generateLadder(List<String> results, List<String> names, int ladderHeight) {
        LadderInOut ladderInOut = new LadderInOut(results, new Users(names));
        LadderLines ladderLines = new LadderLines(names.size(), ladderHeight, new RandomLineStrategy());
        return new Ladder(ladderInOut, ladderLines);
    }
}
