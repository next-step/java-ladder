package nextstep.ladder.application.dto;


public class LadderRequest {
    private String[] participants;
    private String[] results;
    private int highCount;

    public LadderRequest(String[] participants, String[] results, int highCount) {
        this.participants = participants;
        this.results = results;
        this.highCount = highCount;
    }

    public String[] getParticipants() {
        return participants;
    }

    public String[] getResults() {
        return results;
    }

    public int getHighCount() {
        return highCount;
    }
}
