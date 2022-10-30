package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderInOut;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.RandomLineStrategy;
import nextstep.ladder.domain.Users;

public class LadderFactory {

    public Ladder generateLadder(List<String> results, List<String> names, int ladderHeight) {
        LadderInOut ladderInOut = new LadderInOut(results, new Users(names));
        LadderLine ladderLine = new LadderLine(names.size(), ladderHeight, new RandomLineStrategy());
        return new Ladder(ladderInOut, ladderLine);
    }
}
