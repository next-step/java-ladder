package ladder.domain;

public class LadderGame {

    private final Ladder ladder;
    private final Participant participant;

    public LadderGame(int height, String inputText) {
        this(new Ladder(height, getLengthOfLadder(inputText)), new Participant(inputText) );
    }

    private static int getLengthOfLadder(String inputText) {
        return inputText.split(",").length;
    }

    public LadderGame(Ladder ladder, Participant participant) {
        this.ladder = ladder;
        this.participant = participant;
    }

    @Override
    public String toString() {
        return participant.toString() + "\n" + ladder.toString();
    }
}
