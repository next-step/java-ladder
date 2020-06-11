package ladder.domain.ladder;

import ladder.domain.player.LadderPlayers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("Line 이 정상적으로 생성되는지 확인하는 테스트")
    void LineCreateTest() {
        String[] playerNames = {"pobi","honux","po","bi"};
        LadderPlayers ladderPlayers = LadderPlayers.participate(playerNames);
        Line line = Line.createLine(ladderPlayers.getRequestLineCount());
        assertThat(line.getPoints().size()).isEqualTo(ladderPlayers.getPlayerCount());
    }
}
