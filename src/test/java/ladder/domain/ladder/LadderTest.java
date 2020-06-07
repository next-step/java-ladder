package ladder.domain.ladder;

import ladder.domain.player.LadderPlayers;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    void LadderCreateTest() {
        String[] playerNames = {"pobi","honux","po","bi"};
        LadderPlayers ladderPlayers = LadderPlayers.participate(playerNames);
        Line line = Line.createLine(ladderPlayers);

    }
}
