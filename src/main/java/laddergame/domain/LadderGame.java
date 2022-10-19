package laddergame.domain;

import laddergame.component.LadderFactory;
import laddergame.dto.LadderGameResult;
import laddergame.dto.LadderGameRunRequest;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final LadderFactory ladderFactory;

    public LadderGame(LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public LadderGameResult run(LadderGameRunRequest request) {
        List<ParticipantName> participantNames = request.getParticipantNames().stream()
                .map(ParticipantName::new)
                .collect(Collectors.toList());
        Ladder ladder = ladderFactory.createLadder(participantNames.size(), request.getHeight());
        return LadderGameResult.of(participantNames, ladder);
    }

}
