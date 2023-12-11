package nextstep.ladder.service;

import nextstep.ladder.domain.Ladder;

public class LadderService {
    public static Ladder generateLadder(int countOfParticipant, int ladderHeight) {

        return Ladder.generate(countOfParticipant, ladderHeight);
    }

}
