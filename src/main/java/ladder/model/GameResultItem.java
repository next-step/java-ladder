package ladder.model;

public class GameResultItem {
    private Participant participant;
    private ResultItem resultItem;

    public GameResultItem(Participant participant, ResultItem resultItem) {
        this.participant = participant;
        this.resultItem = resultItem;
    }

    public boolean isMatchParticipant(String name) {
        return participant.isMatch(name);
    }

    public String getName() {
        return participant.toString();
    }

    public String getResultName() {
        return resultItem.toString();
    }
}
