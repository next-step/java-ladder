package ladder.domain;

import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final Participants participants;

    public LadderGame(int height, String inputText) {
        this(new Ladder(height, getLengthOfLadder(inputText)), new Participants(inputText) );
    }

    private static int getLengthOfLadder(String inputText) {
        return inputText.split(",").length;
    }

    public LadderGame(Ladder ladder, Participants participants) {
        this.ladder = ladder;
        this.participants = participants;
    }

    public List<Gamer> doStart() {
        return this.participants.startGame(ladder);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Participants getParticipant() {
        return participants;
    }
}
