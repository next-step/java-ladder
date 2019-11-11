package ladder.game;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<LineOfLadder> ladder;

    public Ladder(int personCount, int ladderHeight, ConnectionStrategy connectionStrategy) {
        this.ladder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            this.ladder.add(new LineOfLadder(personCount - 1, connectionStrategy));
        }
    }

    public int getLadderHeight() {
        return ladder.size();
    }

    public boolean isConnected(int line, int width) {
        return ladder.get(line).isConnected(width);
    }
}
