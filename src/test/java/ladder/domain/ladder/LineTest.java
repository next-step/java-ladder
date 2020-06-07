package ladder.domain.ladder;

import ladder.domain.player.LadderPlayers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void LineCreateTest() {
        String[] playerNames = {"pobi","honux","po","bi"};
        LadderPlayers ladderPlayers = LadderPlayers.participate(playerNames);
        Line line = Line.createLine(ladderPlayers);

        assertThat(line.getPoints().size()).isEqualTo(ladderPlayers.getPlayerCount());
    }
}
