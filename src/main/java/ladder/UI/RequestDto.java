package ladder.UI;

public class RequestDto {

    private final String participantNames;
    private final String inputLadderResult;
    private final int ladderHeight;

    public RequestDto(String participantNames, String inputLadderResult, int ladderHeight) {
        this.participantNames = participantNames;
        this.inputLadderResult = inputLadderResult;
        this.ladderHeight = ladderHeight;
    }

    public String getParticipantNames() {
        return participantNames;
    }

    public String getInputLadderResult() {
        return inputLadderResult;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
