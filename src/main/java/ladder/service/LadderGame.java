package ladder.service;

import ladder.domain.Bridge;
import ladder.domain.ConnectionStrategy;
import ladder.domain.Ladder;

import java.util.List;

public class LadderGame {

    public List<Bridge> createLadder(int maxLadderHeight, int participantCount, ConnectionStrategy strategy) {
        Ladder ladder = new Ladder();
        return ladder.createSteps(maxLadderHeight, participantCount, strategy);
    }

}
