package ladder.ui;

public final class LadderBaseInputData {
    private final String participants;
    private final String ladderResult;
    private final int ladderHeight;

    public LadderBaseInputData(String participants, String ladderResult, int ladderHeight) {
        this.participants = participants;
        this.ladderResult = ladderResult;
        this.ladderHeight = ladderHeight;
    }

    public String getParticipants() {
        return participants;
    }

    public String getLadderResult() {
        return ladderResult;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
