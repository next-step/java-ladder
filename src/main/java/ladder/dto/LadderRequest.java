package ladder.dto;

public class LadderRequest {
    private String[] participants;
    private int limitCount;

    public LadderRequest(String[] participants, int highCount) {
        this.participants = participants;
        this.limitCount = highCount;
    }

    public String[] getParticipants() {
        return participants;
    }

    public int getLimitCount() {
        return limitCount;
    }
}
