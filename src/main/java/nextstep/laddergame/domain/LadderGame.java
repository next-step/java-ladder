package nextstep.laddergame.domain;

import java.util.List;

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
            .map(participant -> new LadderResult(participant.name(), ladder.traverse(participant.position())))
            .toList();
    }
}