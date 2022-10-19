package laddergame.domain;

import laddergame.component.LadderFactory;
import laddergame.dto.LadderGameResult;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final LadderFactory ladderFactory;

    public LadderGame(LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public LadderGameResult run(List<String> participantNameValues, int height) {
        List<ParticipantName> participantNames = participantNameValues.stream()
                .map(ParticipantName::new)
                .collect(Collectors.toList());
        Ladder ladder = ladderFactory.createLadder(participantNames.size(), height);
        return LadderGameResult.of(participantNames, ladder);
    }

}
