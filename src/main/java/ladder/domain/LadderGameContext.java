package ladder.domain;

public class LadderGameContext {
    private final Participants participants;
    private final Ladder ladder;
    private final Results results;

    public LadderGameContext(Participants participants, Ladder ladder, Results results) {
        this.participants = participants;
        this.ladder = ladder;
        this.results = results;
    }

    public Participants getParticipants() {
        return participants;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Results getResults() {
        return results;
    }
}
