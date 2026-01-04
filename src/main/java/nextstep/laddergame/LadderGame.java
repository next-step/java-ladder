package nextstep.laddergame;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;

    public LadderGame(String participantsName, String ladderHeight) {
        this(new Participants(participantsName), ladderHeight);
    }

    private LadderGame(Participants participants, String ladderHeight) {
        this(participants, new Ladder(ladderHeight, participants.getParticipantList().size()));
    }

    public LadderGame(Participants participants, Ladder ladder) {
        this.participants = participants;
        this.ladder = ladder;
    }

    public Participants getParticipants() {
        return participants;
    }

    public Ladder getLadder() {
        return ladder;
    }
}