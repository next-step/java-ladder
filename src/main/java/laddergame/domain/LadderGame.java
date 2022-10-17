package laddergame.domain;

import laddergame.component.LadderFactory;
import laddergame.dto.LadderGameResult;

import java.util.List;

public class LadderGame {

    private final LadderFactory ladderFactory;

    public LadderGame(LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public LadderGameResult run(List<ParticipantName> participantNames, int height) {
        Ladder ladder = ladderFactory.createLadder(participantNames.size(), height);
        return new LadderGameResult(participantNames, ladder);
    }

}
