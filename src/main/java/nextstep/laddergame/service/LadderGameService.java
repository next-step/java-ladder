package nextstep.laddergame.service;

import nextstep.laddergame.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameService {
    private static final String ALL_PARTICIPANTS = "all";

    public LadderGame createLadder(List<String> participants, List<String> ladderOutputs, Integer maxHeight,
                                   LaddersFactory laddersFactory, LadderLinesGenerator ladderLinesGenerator) {
        return new LadderGame(participants, ladderOutputs, maxHeight, laddersFactory, ladderLinesGenerator);
    }

    public List<LadderGameResult> resolveGameResults(LadderGame ladderGame, String participantsForResult) {
        Participants participants = getParticipants(ladderGame, participantsForResult);

        return participants.values().stream().map(ladderGame::resolveGameResult).collect(Collectors.toList());
    }

    private Participants getParticipants(LadderGame ladderGame, String participantsForResult) {
        if (ALL_PARTICIPANTS.equals(participantsForResult)) {
            return ladderGame.getParticipants();
        }
        return Participants.from(ladderGame.getParticipant(participantsForResult));
    }
}
