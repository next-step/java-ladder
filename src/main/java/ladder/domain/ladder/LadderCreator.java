package ladder.domain.ladder;

import ladder.domain.player.LadderPlayers;

import java.util.ArrayList;
import java.util.List;

public class LadderCreator {

    private LadderCreator() {

    }

    public static Ladder createLadder(final LadderPlayers LadderPlayers, final int ladderHeight) {
        List<Line> lineList = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {

        }
        return Ladder.create(lineList);
    }
}
