package nextstep.laddergame.domain.game;

import java.util.List;
import nextstep.laddergame.domain.ladder.Ladder;
import nextstep.laddergame.domain.participant.Participants;

public record LadderGame(Participants participants, Ladder ladder) {

    public LadderGame(String participantsName, String ladderHeight) {
        this(new Participants(participantsName), ladderHeight);
    }

    public LadderGame(String participantsName, String ladderHeight, String goals) {
        this(new Participants(participantsName), ladderHeight, goals);
    }

    private LadderGame(Participants participants, String ladderHeight) {
        this(participants, new Ladder(ladderHeight, participants.size()));
    }

    private LadderGame(Participants participants, String ladderHeight, String goals) {
        this(participants, new Ladder(ladderHeight, participants.size(), goals));
    }

    public List<LadderResult> ladderGameResult() {
        return participants.participantList().stream()
            .map(participant -> new LadderResult(participant.name().value(), ladder.traverse(participant.position().value())))
            .toList();
    }
}