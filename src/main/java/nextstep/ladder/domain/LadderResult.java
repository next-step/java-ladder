package nextstep.ladder.domain;

public class LadderResult {
    private ParticipantName name;
    private String result;

    public LadderResult(ParticipantName name, String result) {
        this.name = name;
        this.result = result;
    }

    public ParticipantName getName() {
        return name;
    }

    public String getResult() {
        return result;
    }
}
