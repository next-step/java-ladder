package laddergame.domain;

public class Result {

    private final Participants participants;
    private final LadderLines ladderLines;

    public Result(Participants participants, LadderLines ladderLines) {
        this.participants = participants;
        this.ladderLines = ladderLines;
    }

    public Participants getParticipants() {
        return participants;
    }

    public LadderLines getLadderLines() {
        return ladderLines;
    }
}