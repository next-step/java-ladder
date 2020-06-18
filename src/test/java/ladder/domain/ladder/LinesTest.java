package ladder.domain.ladder;

import ladder.domain.ladder.ladderInfo.LadderHeight;
import ladder.domain.player.LadderPlayers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    @DisplayName("Lines 이 정상적으로 생성되는지 확인하는 테스트")
    void LinesCreateTest() {
        String[] playerNames = {"pobi","honux","po","bi"};
        LadderPlayers ladderPlayers = LadderPlayers.participate(playerNames);
        LadderHeight ladderHeight = LadderHeight.inputHeight(5);

        Lines lines = LinesCreator.create(ladderPlayers.getPlayerCount(), ladderHeight);
        List<Line> lineList = lines.getLineList();

        Lines newLines = new Lines(lineList, ladderPlayers.getPlayerCount());
        assertThat(newLines.getLineList().size()).isEqualTo(5);
    }
}
