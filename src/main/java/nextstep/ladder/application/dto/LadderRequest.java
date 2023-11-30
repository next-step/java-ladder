package nextstep.ladder.application.dto;


public class LadderRequest {
    private String[] participants;
    private int highCount;

    public LadderRequest(String[] participants, int highCount) {
        this.participants = participants;
        this.highCount = highCount;
    }

    public String[] getParticipants() {
        return participants;
    }

    public int getHighCount() {
        return highCount;
    }
}
