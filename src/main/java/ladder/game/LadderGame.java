package ladder.game;

import ladder.structure.Ladder;
import ladder.structure.connection.ConnectionStrategy;

import java.util.Collections;
import java.util.List;

public class LadderGame {
    private static final String LADDER_HEIGHT_EXCEPTION = "사다리게임의 높이는 0 이상입니다.";

    private Ladder ladder;
    private Participants participants;

    public LadderGame(String inputParticipant, int ladderHeight, ConnectionStrategy connectionStrategy) {
        this.participants = Participants.of(inputParticipant);
        this.ladder = new Ladder(this.participants.size(), verityLadderHeight(ladderHeight), connectionStrategy);
    }

    public boolean isConnected(int line, int width) {
        return ladder.isConnected(line, width);
    }

    public int getLadderHeight() {
        return ladder.getLadderHeight();
    }

    public int getLadderWidth() {
        return participants.size() - 1;
    }

    public List<String> getParticipants() {
        return Collections.unmodifiableList(participants.getNames());
    }

    private int verityLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException(LADDER_HEIGHT_EXCEPTION);
        }
        return ladderHeight;
    }

}
