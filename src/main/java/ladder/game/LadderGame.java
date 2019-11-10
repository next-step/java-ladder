package ladder.game;

import java.util.Arrays;
import java.util.List;

public class LadderGame {
    private Ladder ladder;
    private List<String> participants;

    public LadderGame(String participants, int ladderHeight) {
        this.participants = Arrays.asList(participants.replace(" ", "").split(","));
        this.ladder = new Ladder(this.participants.size(), ladderHeight);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getParticipants() {
        return participants;
    }
}
