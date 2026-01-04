package nextstep.laddergame;

public record LadderGame(Participants participants, Ladder ladder) {

    public LadderGame(String participantsName, String ladderHeight) {
        this(new Participants(participantsName), ladderHeight);
    }

    private LadderGame(Participants participants, String ladderHeight) {
        this(participants, new Ladder(ladderHeight, participants.participantList().size()));
    }

}