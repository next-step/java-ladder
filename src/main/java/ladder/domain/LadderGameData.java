package ladder.domain;

public class LadderGameData {
    private final String[] participantNames;
    private final String[] outcomes;

    public LadderGameData(String[] participantNames, String[] outcomes) {
        this.participantNames = participantNames;
        this.outcomes = outcomes;
    }

    public String[] getParticipantNames() {
        return participantNames;
    }

    public String[] getOutcomes() {
        return outcomes;
    }

}
